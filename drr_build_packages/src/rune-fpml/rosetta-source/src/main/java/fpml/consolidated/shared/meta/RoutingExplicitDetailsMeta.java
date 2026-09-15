package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RoutingExplicitDetails;
import fpml.consolidated.shared.validation.RoutingExplicitDetailsTypeFormatValidator;
import fpml.consolidated.shared.validation.RoutingExplicitDetailsValidator;
import fpml.consolidated.shared.validation.exists.RoutingExplicitDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RoutingExplicitDetails.class)
public class RoutingExplicitDetailsMeta implements RosettaMetaData<RoutingExplicitDetails> {

	@Override
	public List<Validator<? super RoutingExplicitDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingExplicitDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RoutingExplicitDetails> validator(ValidatorFactory factory) {
		return factory.<RoutingExplicitDetails>create(RoutingExplicitDetailsValidator.class);
	}

	@Override
	public Validator<? super RoutingExplicitDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RoutingExplicitDetails>create(RoutingExplicitDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RoutingExplicitDetails> validator() {
		return new RoutingExplicitDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RoutingExplicitDetails> typeFormatValidator() {
		return new RoutingExplicitDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingExplicitDetails, Set<String>> onlyExistsValidator() {
		return new RoutingExplicitDetailsOnlyExistsValidator();
	}
}
