package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Routing;
import fpml.consolidated.shared.validation.RoutingTypeFormatValidator;
import fpml.consolidated.shared.validation.RoutingValidator;
import fpml.consolidated.shared.validation.datarule.RoutingChoice;
import fpml.consolidated.shared.validation.exists.RoutingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Routing.class)
public class RoutingMeta implements RosettaMetaData<Routing> {

	@Override
	public List<Validator<? super Routing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Routing>create(RoutingChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Routing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Routing> validator(ValidatorFactory factory) {
		return factory.<Routing>create(RoutingValidator.class);
	}

	@Override
	public Validator<? super Routing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Routing>create(RoutingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Routing> validator() {
		return new RoutingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Routing> typeFormatValidator() {
		return new RoutingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Routing, Set<String>> onlyExistsValidator() {
		return new RoutingOnlyExistsValidator();
	}
}
