package cdm.product.asset.meta;

import cdm.product.asset.Tranche;
import cdm.product.asset.validation.TrancheTypeFormatValidator;
import cdm.product.asset.validation.TrancheValidator;
import cdm.product.asset.validation.datarule.TrancheAttachmentPoint;
import cdm.product.asset.validation.datarule.TrancheAttachmentPointLessThanExhaustionPoint;
import cdm.product.asset.validation.datarule.TrancheExhaustionPoint;
import cdm.product.asset.validation.exists.TrancheOnlyExistsValidator;
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
@RosettaMeta(model=Tranche.class)
public class TrancheMeta implements RosettaMetaData<Tranche> {

	@Override
	public List<Validator<? super Tranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Tranche>create(TrancheAttachmentPoint.class),
			factory.<Tranche>create(TrancheExhaustionPoint.class),
			factory.<Tranche>create(TrancheAttachmentPointLessThanExhaustionPoint.class)
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
