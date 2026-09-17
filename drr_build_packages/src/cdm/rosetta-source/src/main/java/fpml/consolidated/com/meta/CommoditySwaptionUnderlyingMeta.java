package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySwaptionUnderlying;
import fpml.consolidated.com.validation.CommoditySwaptionUnderlyingTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySwaptionUnderlyingValidator;
import fpml.consolidated.com.validation.datarule.CommoditySwaptionUnderlyingChoice;
import fpml.consolidated.com.validation.exists.CommoditySwaptionUnderlyingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySwaptionUnderlying.class)
public class CommoditySwaptionUnderlyingMeta implements RosettaMetaData<CommoditySwaptionUnderlying> {

	@Override
	public List<Validator<? super CommoditySwaptionUnderlying>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommoditySwaptionUnderlying>create(CommoditySwaptionUnderlyingChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommoditySwaptionUnderlying, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySwaptionUnderlying> validator(ValidatorFactory factory) {
		return factory.<CommoditySwaptionUnderlying>create(CommoditySwaptionUnderlyingValidator.class);
	}

	@Override
	public Validator<? super CommoditySwaptionUnderlying> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySwaptionUnderlying>create(CommoditySwaptionUnderlyingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwaptionUnderlying> validator() {
		return new CommoditySwaptionUnderlyingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwaptionUnderlying> typeFormatValidator() {
		return new CommoditySwaptionUnderlyingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwaptionUnderlying, Set<String>> onlyExistsValidator() {
		return new CommoditySwaptionUnderlyingOnlyExistsValidator();
	}
}
