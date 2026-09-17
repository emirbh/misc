package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.Tranche;
import fpml.consolidated.cd.validation.TrancheTypeFormatValidator;
import fpml.consolidated.cd.validation.TrancheValidator;
import fpml.consolidated.cd.validation.exists.TrancheOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Tranche.class)
public class TrancheMeta implements RosettaMetaData<Tranche> {

	@Override
	public List<Validator<? super Tranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Tranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Tranche> validator(ValidatorFactory factory) {
		return factory.<Tranche>create(TrancheValidator.class);
	}

	@Override
	public Validator<? super Tranche> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Tranche>create(TrancheTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Tranche> validator() {
		return new TrancheValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Tranche> typeFormatValidator() {
		return new TrancheTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Tranche, Set<String>> onlyExistsValidator() {
		return new TrancheOnlyExistsValidator();
	}
}
