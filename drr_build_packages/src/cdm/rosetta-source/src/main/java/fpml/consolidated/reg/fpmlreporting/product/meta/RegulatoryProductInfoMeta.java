package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryProductInfo;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryProductInfoTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryProductInfoValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryProductInfoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryProductInfo.class)
public class RegulatoryProductInfoMeta implements RosettaMetaData<RegulatoryProductInfo> {

	@Override
	public List<Validator<? super RegulatoryProductInfo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryProductInfo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryProductInfo> validator(ValidatorFactory factory) {
		return factory.<RegulatoryProductInfo>create(RegulatoryProductInfoValidator.class);
	}

	@Override
	public Validator<? super RegulatoryProductInfo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryProductInfo>create(RegulatoryProductInfoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryProductInfo> validator() {
		return new RegulatoryProductInfoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryProductInfo> typeFormatValidator() {
		return new RegulatoryProductInfoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryProductInfo, Set<String>> onlyExistsValidator() {
		return new RegulatoryProductInfoOnlyExistsValidator();
	}
}
