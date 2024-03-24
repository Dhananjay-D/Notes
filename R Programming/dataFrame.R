id=c(11,12,13,14)
name=c("arun","vijay","rohan","ajay")

res=data.frame(id,name)
print(res)

print("Accessing list: ")

#accessing elements based on our requirements
print(res[1:2,1:2])


# subset of the dataFrame :
df=data.frame("Area"=c("mumbai","delhi","goa","noida"),"Population"=c(10000,5000,2000,900))

res2=subset(df,name=="mumbai"| Population > 1000)

print(res2)


# editing dataframe using edit command
myTable=data.frame()
myTable=edit(myTable)
print(myTable)

#adding new variable to the existing dataframe using :   mutate() command
library(dplyr)
df2=data.frame("Area"=c("mumbai","delhi","goa","noida"),"Population"=c(10000,5000,2000,900))
res3=mutate(df2,log_population=log(Population))
print(res3)
