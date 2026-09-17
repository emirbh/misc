package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.PostedCreditSupportItem;
import cdm.legaldocumentation.csa.validation.PostedCreditSupportItemTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.PostedCreditSupportItemValidator;
import cdm.legaldocumentation.csa.validation.exists.PostedCreditSupportItemOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=PostedCreditSupportItem.class)
public class PostedCreditSupportItemMeta implements RosettaMetaData<PostedCreditSupportItem> {

	@Override
	public List<Validator<? super PostedCreditSupportItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostedCreditSupportItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostedCreditSupportItem> validator(ValidatorFactory factory) {
		return factory.<PostedCreditSupportItem>create(PostedCreditSupportItemValidator.class);
	}

	@Override
	public Validator<? super PostedCreditSupportItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostedCreditSupportItem>create(PostedCreditSupportItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostedCreditSupportItem> validator() {
		return new PostedCreditSupportItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PostedCreditSupportItem> typeFormatValidator() {
		return new PostedCreditSupportItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostedCreditSupportItem, Set<String>> onlyExistsValidator() {
		return new PostedCreditSupportItemOnlyExistsValidator();
	}
}
