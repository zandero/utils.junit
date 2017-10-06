# utils.junit
JUnit helpers and extensions
 
## Setup
```xml
<dependency>      
     <groupId>com.zandero</groupId>      
     <artifactId>utils.junit</artifactId>      
     <version>0.1</version>
     <scope>test</scope>      
</dependency>
```

## Usage

### Make sure final classes are well defined

- checks that class final 
- checks that it has only one private constructor
- checks all methods should are static

```java

    @Test
    public void checkDefinition() {
        AssertFinalClass.isWellDefined(FinalClass.class);
    }
```

