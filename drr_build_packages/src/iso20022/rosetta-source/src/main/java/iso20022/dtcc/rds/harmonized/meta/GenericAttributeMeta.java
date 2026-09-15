package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.GenericAttribute;
import iso20022.dtcc.rds.harmonized.validation.GenericAttributeTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.GenericAttributeValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.GenericAttributeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericAttribute.class)
public class GenericAttributeMeta implements RosettaMetaData<GenericAttribute> {

	@Override
	public List<Validator<? super GenericAttribute>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericAttribute, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericAttribute> validator(ValidatorFactory factory) {
		return factory.<GenericAttribute>create(GenericAttributeValidator.class);
	}

	@Override
	public Validator<? super GenericAttribute> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericAttribute>create(GenericAttributeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericAttribute> validator() {
		return new GenericAttributeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericAttribute> typeFormatValidator() {
		return new GenericAttributeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericAttribute, Set<String>> onlyExistsValidator() {
		return new GenericAttributeOnlyExistsValidator();
	}
}
