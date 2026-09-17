package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CouponType;
import fpml.consolidated.asset.validation.CouponTypeTypeFormatValidator;
import fpml.consolidated.asset.validation.CouponTypeValidator;
import fpml.consolidated.asset.validation.exists.CouponTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CouponType.class)
public class CouponTypeMeta implements RosettaMetaData<CouponType> {

	@Override
	public List<Validator<? super CouponType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CouponType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CouponType> validator(ValidatorFactory factory) {
		return factory.<CouponType>create(CouponTypeValidator.class);
	}

	@Override
	public Validator<? super CouponType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CouponType>create(CouponTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CouponType> validator() {
		return new CouponTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CouponType> typeFormatValidator() {
		return new CouponTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CouponType, Set<String>> onlyExistsValidator() {
		return new CouponTypeOnlyExistsValidator();
	}
}
