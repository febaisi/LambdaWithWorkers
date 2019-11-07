# LambdaWithWorkers
### Passing lambdas functions to Workers. 

<br>

Motivation: https://stackoverflow.com/questions/55605538/how-can-i-pass-a-lambda-to-the-myworkmanager-class <br>
The idea behind this, is the create a wrapper serialized object which stores a lambda function that will be later called from a worker. <br>
In this case, we will android.util.Log the time that the worker request was built - Compare with the Worker log. So, yeah, look through the logs to check the result of this sample.

<br><br>


--Felipe Baisi
