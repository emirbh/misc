package cdm.product.template.meta;

import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.validation.EarlyTerminationProvisionTypeFormatValidator;
import cdm.product.template.validation.EarlyTerminationProvisionValidator;
import cdm.product.template.validation.datarule.EarlyTerminationProvisionMandatoryEarlyTermination;
import cdm.product.template.validation.exists.EarlyTerminationProvisionOnlyExistsValidator;
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
@RosettaMeta(model=EarlyTerminationProvision.class)
public class EarlyTerminationProvisionMeta implements RosettaMetaData<EarlyTerminationProvision> {

	@Override
	public List<Validator<? super EarlyTerminationProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EarlyTerminationProvision>create(EarlyTerminationProvisionMandatoryEarlyTermination.class)
		);
	}
	
	@Override
	public List<Function<? super EarlyTerminationProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EarlyTerminationProvision> validator(ValidatorFactory factory) {
		return factory.<EarlyTerminationProvision>create(EarlyTerminationProvisionValidator.class);
	}

	@Override
	public Validator<? super EarlyTerminationProvision> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EarlyTerminationProvision>create(EarlyTerminationProvisionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationProvision> validator() {
		return new EarlyTerminationProvisionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationProvision> typeFormatValidator() {
		return new EarlyTerminationProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EarlyTerminationProvision, Set<String>> onlyExistsValidator() {
		return new EarlyTerminationProvisionOnlyExistsValidator();
	}
}
