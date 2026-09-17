package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
import cdm.legaldocumentation.csa.validation.MinimumTransferAmountAmendmentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MinimumTransferAmountAmendmentValidator;
import cdm.legaldocumentation.csa.validation.datarule.MinimumTransferAmountAmendmentAmendmentNotApplicable;
import cdm.legaldocumentation.csa.validation.exists.MinimumTransferAmountAmendmentOnlyExistsValidator;
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
@RosettaMeta(model=MinimumTransferAmountAmendment.class)
public class MinimumTransferAmountAmendmentMeta implements RosettaMetaData<MinimumTransferAmountAmendment> {

	@Override
	public List<Validator<? super MinimumTransferAmountAmendment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MinimumTransferAmountAmendment>create(MinimumTransferAmountAmendmentAmendmentNotApplicable.class)
		);
	}
	
	@Override
	public List<Function<? super MinimumTransferAmountAmendment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MinimumTransferAmountAmendment> validator(ValidatorFactory factory) {
		return factory.<MinimumTransferAmountAmendment>create(MinimumTransferAmountAmendmentValidator.class);
	}

	@Override
	public Validator<? super MinimumTransferAmountAmendment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MinimumTransferAmountAmendment>create(MinimumTransferAmountAmendmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MinimumTransferAmountAmendment> validator() {
		return new MinimumTransferAmountAmendmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MinimumTransferAmountAmendment> typeFormatValidator() {
		return new MinimumTransferAmountAmendmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MinimumTransferAmountAmendment, Set<String>> onlyExistsValidator() {
		return new MinimumTransferAmountAmendmentOnlyExistsValidator();
	}
}
