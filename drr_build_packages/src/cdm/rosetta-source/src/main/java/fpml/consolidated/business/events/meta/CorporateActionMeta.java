package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CorporateAction;
import fpml.consolidated.business.events.validation.CorporateActionTypeFormatValidator;
import fpml.consolidated.business.events.validation.CorporateActionValidator;
import fpml.consolidated.business.events.validation.exists.CorporateActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorporateAction.class)
public class CorporateActionMeta implements RosettaMetaData<CorporateAction> {

	@Override
	public List<Validator<? super CorporateAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorporateAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorporateAction> validator(ValidatorFactory factory) {
		return factory.<CorporateAction>create(CorporateActionValidator.class);
	}

	@Override
	public Validator<? super CorporateAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorporateAction>create(CorporateActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorporateAction> validator() {
		return new CorporateActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorporateAction> typeFormatValidator() {
		return new CorporateActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorporateAction, Set<String>> onlyExistsValidator() {
		return new CorporateActionOnlyExistsValidator();
	}
}
