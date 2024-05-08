val anExp = throw new IllegalArgumentException


// return type -> Nothing
def getInt() = throw new RuntimeException("failed..")

val potentialFail = 
try {
  getInt()
}
catch {
  case e: RuntimeException => 2
}
finally {
  println("finally ran")
}


println(potentialFail)