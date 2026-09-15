package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CorporateActionType;
import fpml.consolidated.business.events.validation.CorporateActionTypeTypeFormatValidator;
import fpml.consolidated.business.events.validation.CorporateActionTypeValidator;
import fpml.consolidated.business.events.validation.exists.CorporateActionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorporateActionType.class)
public class CorporateActionTypeMeta implements RosettaMetaData<CorporateActionType> {

	@Override
	public List<Validator<? super CorporateActionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorporateActionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorporateActionType> validator(ValidatorFactory factory) {
		return factory.<CorporateActionType>create(CorporateActionTypeValidator.class);
	}

	@Override
	public Validator<? super CorporateActionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorporateActionType>create(CorporateActionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorporateActionType> validator() {
		return new CorporateActionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorporateActionType> typeFormatValidator() {
		return new CorporateActionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorporateActionType, Set<String>> onlyExistsValidator() {
		return new CorporateActionTypeOnlyExistsValidator();
	}
}
