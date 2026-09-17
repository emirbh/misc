package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
import cdm.legaldocumentation.csa.validation.PledgeeRepresentativeRiderTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.PledgeeRepresentativeRiderValidator;
import cdm.legaldocumentation.csa.validation.datarule.PledgeeRepresentativeRiderRepresentativeEventTerms;
import cdm.legaldocumentation.csa.validation.datarule.PledgeeRepresentativeRiderRepresentativeParty;
import cdm.legaldocumentation.csa.validation.exists.PledgeeRepresentativeRiderOnlyExistsValidator;
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
@RosettaMeta(model=PledgeeRepresentativeRider.class)
public class PledgeeRepresentativeRiderMeta implements RosettaMetaData<PledgeeRepresentativeRider> {

	@Override
	public List<Validator<? super PledgeeRepresentativeRider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PledgeeRepresentativeRider>create(PledgeeRepresentativeRiderRepresentativeParty.class),
			factory.<PledgeeRepresentativeRider>create(PledgeeRepresentativeRiderRepresentativeEventTerms.class)
		);
	}
	
	@Override
	public List<Function<? super PledgeeRepresentativeRider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PledgeeRepresentativeRider> validator(ValidatorFactory factory) {
		return factory.<PledgeeRepresentativeRider>create(PledgeeRepresentativeRiderValidator.class);
	}

	@Override
	public Validator<? super PledgeeRepresentativeRider> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PledgeeRepresentativeRider>create(PledgeeRepresentativeRiderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PledgeeRepresentativeRider> validator() {
		return new PledgeeRepresentativeRiderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PledgeeRepresentativeRider> typeFormatValidator() {
		return new PledgeeRepresentativeRiderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PledgeeRepresentativeRider, Set<String>> onlyExistsValidator() {
		return new PledgeeRepresentativeRiderOnlyExistsValidator();
	}
}
