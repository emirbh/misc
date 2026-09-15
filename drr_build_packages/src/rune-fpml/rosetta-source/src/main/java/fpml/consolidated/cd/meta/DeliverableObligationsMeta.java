package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.DeliverableObligations;
import fpml.consolidated.cd.validation.DeliverableObligationsTypeFormatValidator;
import fpml.consolidated.cd.validation.DeliverableObligationsValidator;
import fpml.consolidated.cd.validation.datarule.DeliverableObligationsChoice;
import fpml.consolidated.cd.validation.exists.DeliverableObligationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeliverableObligations.class)
public class DeliverableObligationsMeta implements RosettaMetaData<DeliverableObligations> {

	@Override
	public List<Validator<? super DeliverableObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DeliverableObligations>create(DeliverableObligationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DeliverableObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliverableObligations> validator(ValidatorFactory factory) {
		return factory.<DeliverableObligations>create(DeliverableObligationsValidator.class);
	}

	@Override
	public Validator<? super DeliverableObligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeliverableObligations>create(DeliverableObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeliverableObligations> validator() {
		return new DeliverableObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeliverableObligations> typeFormatValidator() {
		return new DeliverableObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliverableObligations, Set<String>> onlyExistsValidator() {
		return new DeliverableObligationsOnlyExistsValidator();
	}
}
