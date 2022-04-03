# utils.junit
JUnit helpers and extensions
 
## Setup
```xml
JAVA 11
<dependency>
    <groupId>com.zandero</groupId>
    <artifactId>utils.junit</artifactId>
    <version>1.1</version>
    <scope>test</scope>
</dependency>

JAVA8
<dependency>      
     <groupId>com.zandero</groupId>      
     <artifactId>utils.junit</artifactId>      
     <version>1.0.1</version>
     <scope>test</scope>      
</dependency>
```

## Usage

### Make sure final classes are well-defined

- checks class is final 
- checks class has only one private constructor
- checks methods are static

```java

    @Test
    public void checkDefinition() {
        AssertFinalClass.isWellDefined(FinalClass.class);
    }
```

