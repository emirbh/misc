package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.Representations;
import fpml.consolidated.eq.shared.validation.RepresentationsTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.RepresentationsValidator;
import fpml.consolidated.eq.shared.validation.exists.RepresentationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Representations.class)
public class RepresentationsMeta implements RosettaMetaData<Representations> {

	@Override
	public List<Validator<? super Representations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Representations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Representations> validator(ValidatorFactory factory) {
		return factory.<Representations>create(RepresentationsValidator.class);
	}

	@Override
	public Validator<? super Representations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Representations>create(RepresentationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Representations> validator() {
		return new RepresentationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Representations> typeFormatValidator() {
		return new RepresentationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Representations, Set<String>> onlyExistsValidator() {
		return new RepresentationsOnlyExistsValidator();
	}
}
