package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.OtherEligibleAndPostedSupport;
import cdm.legaldocumentation.csa.validation.OtherEligibleAndPostedSupportTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.OtherEligibleAndPostedSupportValidator;
import cdm.legaldocumentation.csa.validation.exists.OtherEligibleAndPostedSupportOnlyExistsValidator;
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
@RosettaMeta(model=OtherEligibleAndPostedSupport.class)
public class OtherEligibleAndPostedSupportMeta implements RosettaMetaData<OtherEligibleAndPostedSupport> {

	@Override
	public List<Validator<? super OtherEligibleAndPostedSupport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherEligibleAndPostedSupport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherEligibleAndPostedSupport> validator(ValidatorFactory factory) {
		return factory.<OtherEligibleAndPostedSupport>create(OtherEligibleAndPostedSupportValidator.class);
	}

	@Override
	public Validator<? super OtherEligibleAndPostedSupport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtherEligibleAndPostedSupport>create(OtherEligibleAndPostedSupportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtherEligibleAndPostedSupport> validator() {
		return new OtherEligibleAndPostedSupportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtherEligibleAndPostedSupport> typeFormatValidator() {
		return new OtherEligibleAndPostedSupportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherEligibleAndPostedSupport, Set<String>> onlyExistsValidator() {
		return new OtherEligibleAndPostedSupportOnlyExistsValidator();
	}
}
