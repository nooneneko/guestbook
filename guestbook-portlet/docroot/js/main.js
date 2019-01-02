AUI().use("aui-char-counter",
  function(A) {
    new A.CharCounter(
      {
        counter: '#messageCounter',
        input: '#<portlet:namespace />message',
        maxLength: 140
      }
    );
  }
);