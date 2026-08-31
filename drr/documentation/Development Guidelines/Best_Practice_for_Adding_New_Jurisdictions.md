# Best Practice in DRR

## 1. Introduction
Over time, the DRR community has experimented with different methods of digitising jurisdictional requirements.  
In 2025, a major refactoring of the rules was completed to maximise re-use of common elements.  
This enables contributors to reduce duplication and improve maintainability when adding new jurisdictions.  

This document sets out the best practices for incorporating new jurisdictions into DRR, making use of the latest functionality in the RUNE DSL and shared common types. 

## 1a. Process of Adding a New Jurisdiction

The process of incorporating a new jurisdiction into DRR involves a few key steps:  

1. **Analyse reportable attributes**  
   Identify all reportable fields required in the `NewTransactionReport` object.  

2. **Determine common vs. unique fields**  
   During the analysis, distinguish which fields are:  
   - Already part of `CommonTransactionReport` therefore will not need to be added to NewTransactionReport
   - Not required by the new jurisdiction but attributes already part of `CommonTransactionReport`, therefore need to `override [ruleReference empty]`
   - Unique to new jurisdiction therefore need to be added to the `NewTransactionReport`
   - Which fields are shared by at least 1 other existing jurisdiction therefore need to be added to `CommonTransactionReport`
        - In jurisdictions where those new common attributes are not reportable, set the `ruleReferences` to empty. 

3. **Documenting Common attributes**   
    During the analysis, document which new fields are common and adding those new fields or existing common fields to DRR Unique Fields in Airtable to track creating new columns for the new jurisdiction

4. **Compare attribute mappings/ruleReferences**  
   Assess how the mappings for jurisdiction-specific attributes differ from the existing implementations for common attributes.  
   - Understand how the mapping of the fields differ from existing rule making use of existing rule
   - Adjusting the common reporting rules if needed
   - if new common attribute then move rule to common namespace

5. **Compare Validations**  
   Assess how the validations for jurisdiction-specific attributes differ from the existing implementations for common validations.  
   - Understand how the validations of the fields differ from existing rule making use of common validations
   - If validations are shared across already implemented jurisdictions then create common validations

## 2. Type Structuring

### 2.1 Guideline
The latest RUNE DSL allows labels, ruleReferences, and regulatoryReferences to be attached directly to both simple and complex types.  

### 2.2 Rules
- ✅ Do attach regulatory metadata directly to types.  
- ✅ Do follow the standard order:  
  1. Labels  
  2. RegulatoryReferences  
  3. RuleReferences  

- ❌ Do not use empty ruleReferences to capture regulatoryReferences set empty overrides onto types.  
- ❌ Do not rely on rule source (rule source will be deprecated).  

### 2.3 Examples

```
override attribute boolean (0..1)
        [label "Test Label"]
        [regulatoryReference Jurisdiction table "1" dataElement "13" field "Attribute"
            provision "Example Provision"]
        [ruleReference AttributeRule]
```

```
override attribute Type (0..1)
        [ruleReference empty]
```

```
override attribute ComplexType (0..1)
        [label for nestedAttribute "Test Label"]
        [regulatoryReference for nestedAttribute Jurisdiction table "2" dataElement "55" field "Nested Attribute"
            provision "Example Provision"]
        [ruleReference for nestedAttribute NestedAttributeRule]

        [label for nestedAttribute2 "Test Label"]
        [regulatoryReference for nestedAttribute2 Jurisdiction table "2" dataElement "55" field "Nested Attribute2"
            provision "Example Provision"]
        [ruleReference for nestedAttribute NestedAttributeRule2]
```
---

## 3. Adding New Mappings for Jurisdictions

### 3.1 Guideline
All new jurisdiction-specific mappings should leverage the `CommonTransactionReport` and `CriticalDataElement` types introduced in the 2025 refactoring.  

### 3.2 Rules
- ✅ Do add attributes to `CommonTransactionReport` if they are required by more than one jurisdiction.  
- ✅ Do relax type restrictions at the common level if necessary, then reapply stricter type restrictions at the jurisdiction level.  
- ✅ Do reuse existing ruleReferences in the common namespace.  

- ❌ Do not duplicate logic that already exists in `CommonTransactionReport`.  

### 3.3 Examples

 ```
 type NewJurisdictionTransactionReport extends common.CommonTransactionReport:
    [rootType]
    override existingAttribute Type (1..1)
        [label "Test Label"]
        [regulatoryReference Jurisdiction table "1" dataElement "13" field "Attribute"
            provision "Example Provision"]
        [ruleReference AttributeRule]
    newAttribute
        [label "Test Label"]
        [regulatoryReference Jurisdiction table "1" dataElement "13" field "Attribute"
            provision "Example Provision"]
        [ruleReference AttributeRule]
```
---

## 4. Writing Rules

### 4.1 Guideline
When adding rules for attributes already defined in `CommonTransactionReport`:  

- ✅ Make use of the existing common ruleReferences if applicable.  
- ✅ Clearly write code so jurisdiction specific divergences are easy to identify and maintain.  

- ❌ Do not write rule references from scratch if we have existing common ruleReferences.  

### 4.2 Examples
```
reporting rule JurisdictionSpecificRule from TransactionReportInstruction: <"Cleared">
    filter IsAllowableAction
    then extract
        if common.CommonRule = value
        then extract jurisdiction
        else common.CommonRule
```

---

## 5. Validations

### 5.1 Guideline
When implementing new validations cross-examine validations with attributes that already exist existing jurisdictions

- ✅ Make use of the existing common validations if applicable.    
- ✅ Addition of common validations if applicable and apply to all jurisdictions where applicable.    

- ❌ Do not write validations from scratch if we have existing common validations.  

### 5.2 Examples
```
condition New_Common_Validation:
        Common_Validation(a,b,c)

```

```
func Common_Validation:
    inputs:
        a a_Variable (1..1)
        b b_Variable (1..1)
        c c_Variable (0..1)
    output:
        result boolean (0..1)
    set result:
        if Validation_Logic = True then True else False
```
---

## 6. Reference Model for types and rule references: ESMA EMIR (as of August 2025)
The ESMA EMIR regime is a model implementation of these practices. It demonstrates:  

- ✅ Direct use of ruleReferences on types.  
- ✅ Rule namespaces free from unnecessary regulatory information.  
- ✅ Shared attributes defined centrally in `CommonTransactionReport`.  
- ✅ Rules all use common rules with divergences clear.  

👉 Future jurisdictions should use ESMA EMIR as the benchmark for implementation consistency.  
