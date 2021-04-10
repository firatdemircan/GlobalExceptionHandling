# GlobalExceptionHandling
Global Exception Handling With Response Enitity(Spring boot application)

Its a application for handling exceptions in the global class.(Spring boot rest api with response entity)

Basically we create a api error class and defining the universal excepting array.

Then we create a class that extends from ResponseEntityExceptionHandler

after that we override the expceptions in that class or definning the exception that super class didnt have implementetions.

For example;

     @ExceptionHandler({ InvalidDefinitionException.class })
        public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            InvalidDefinitionException ex, WebRequest request) {
        String error =
                ex +  ;

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
    
this is a exception that super class dosent have, so we implementing

    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
            String error =
                    ex.getMessage();

            ApiError apiError =
                    new ApiError(HttpStatus.BAD_REQUEST, "There is no object for this id", error);

            return new ResponseEntity<Object>(
                    apiError, apiError.getStatus());
    }

and that is a exception that super class have but we want use our implementesion.
