package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbIndexTranche;
import drr.standards.iosco.upi.validation.AnnaDsbIndexTrancheTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbIndexTrancheValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbIndexTrancheOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbIndexTranche.class)
public class AnnaDsbIndexTrancheMeta implements RosettaMetaData<AnnaDsbIndexTranche> {

	@Override
	public List<Validator<? super AnnaDsbIndexTranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbIndexTranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbIndexTranche> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbIndexTranche>create(AnnaDsbIndexTrancheValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbIndexTranche> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbIndexTranche>create(AnnaDsbIndexTrancheTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbIndexTranche> validator() {
		return new AnnaDsbIndexTrancheValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbIndexTranche> typeFormatValidator() {
		return new AnnaDsbIndexTrancheTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbIndexTranche, Set<String>> onlyExistsValidator() {
		return new AnnaDsbIndexTrancheOnlyExistsValidator();
	}
}
