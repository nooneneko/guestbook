/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.imsw.service;

import com.imsw.model.AuthorClp;
import com.imsw.model.BookClp;
import com.imsw.model.BorrowerClp;
import com.imsw.model.LoanClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"borrow-book-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"borrow-book-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "borrow-book-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AuthorClp.class.getName())) {
			return translateInputAuthor(oldModel);
		}

		if (oldModelClassName.equals(BookClp.class.getName())) {
			return translateInputBook(oldModel);
		}

		if (oldModelClassName.equals(BorrowerClp.class.getName())) {
			return translateInputBorrower(oldModel);
		}

		if (oldModelClassName.equals(LoanClp.class.getName())) {
			return translateInputLoan(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAuthor(BaseModel<?> oldModel) {
		AuthorClp oldClpModel = (AuthorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuthorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBook(BaseModel<?> oldModel) {
		BookClp oldClpModel = (BookClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBookRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBorrower(BaseModel<?> oldModel) {
		BorrowerClp oldClpModel = (BorrowerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBorrowerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLoan(BaseModel<?> oldModel) {
		LoanClp oldClpModel = (LoanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLoanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.imsw.model.impl.AuthorImpl")) {
			return translateOutputAuthor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.imsw.model.impl.BookImpl")) {
			return translateOutputBook(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.imsw.model.impl.BorrowerImpl")) {
			return translateOutputBorrower(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.imsw.model.impl.LoanImpl")) {
			return translateOutputLoan(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.imsw.AuthorAddressException")) {
			return new com.imsw.AuthorAddressException();
		}

		if (className.equals("com.imsw.AuthorEmailException")) {
			return new com.imsw.AuthorEmailException();
		}

		if (className.equals("com.imsw.AuthorNameException")) {
			return new com.imsw.AuthorNameException();
		}

		if (className.equals("com.imsw.BookCostException")) {
			return new com.imsw.BookCostException();
		}

		if (className.equals("com.imsw.BookTitleException")) {
			return new com.imsw.BookTitleException();
		}

		if (className.equals("com.imsw.BorrowerAddressException")) {
			return new com.imsw.BorrowerAddressException();
		}

		if (className.equals("com.imsw.BorrowerCityException")) {
			return new com.imsw.BorrowerCityException();
		}

		if (className.equals("com.imsw.BorrowerEmailException")) {
			return new com.imsw.BorrowerEmailException();
		}

		if (className.equals("com.imsw.BorrowerNameException")) {
			return new com.imsw.BorrowerNameException();
		}

		if (className.equals("com.imsw.BorrowerPhoneNoException")) {
			return new com.imsw.BorrowerPhoneNoException();
		}

		if (className.equals("com.imsw.LoanDateFinishException")) {
			return new com.imsw.LoanDateFinishException();
		}

		if (className.equals("com.imsw.LoanDateStartException")) {
			return new com.imsw.LoanDateStartException();
		}

		if (className.equals("com.imsw.NoSuchAuthorException")) {
			return new com.imsw.NoSuchAuthorException();
		}

		if (className.equals("com.imsw.NoSuchBookException")) {
			return new com.imsw.NoSuchBookException();
		}

		if (className.equals("com.imsw.NoSuchBorrowerException")) {
			return new com.imsw.NoSuchBorrowerException();
		}

		if (className.equals("com.imsw.NoSuchLoanException")) {
			return new com.imsw.NoSuchLoanException();
		}

		return throwable;
	}

	public static Object translateOutputAuthor(BaseModel<?> oldModel) {
		AuthorClp newModel = new AuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBook(BaseModel<?> oldModel) {
		BookClp newModel = new BookClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBookRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBorrower(BaseModel<?> oldModel) {
		BorrowerClp newModel = new BorrowerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBorrowerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLoan(BaseModel<?> oldModel) {
		LoanClp newModel = new LoanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLoanRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}