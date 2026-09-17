package fpml.consolidated.fx;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.meta.TermDepositFeaturesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="TermDepositFeatures", builder=TermDepositFeatures.TermDepositFeaturesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TermDepositFeatures", model="fpml", builder=TermDepositFeatures.TermDepositFeaturesBuilderImpl.class, version="2.1.1")
public interface TermDepositFeatures extends RosettaModelObject {

	TermDepositFeaturesMeta metaData = new TermDepositFeaturesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	DualCurrencyFeature getDualCurrency();

	/*********************** Build Methods  ***********************/
	TermDepositFeatures build();
	
	TermDepositFeatures.TermDepositFeaturesBuilder toBuilder();
	
	static TermDepositFeatures.TermDepositFeaturesBuilder builder() {
		return new TermDepositFeatures.TermDepositFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermDepositFeatures> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TermDepositFeatures> getType() {
		return TermDepositFeatures.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dualCurrency"), processor, DualCurrencyFeature.class, getDualCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermDepositFeaturesBuilder extends TermDepositFeatures, RosettaModelObjectBuilder {
		DualCurrencyFeature.DualCurrencyFeatureBuilder getOrCreateDualCurrency();
		@Override
		DualCurrencyFeature.DualCurrencyFeatureBuilder getDualCurrency();
		TermDepositFeatures.TermDepositFeaturesBuilder setDualCurrency(DualCurrencyFeature dualCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dualCurrency"), processor, DualCurrencyFeature.DualCurrencyFeatureBuilder.class, getDualCurrency());
		}
		

		TermDepositFeatures.TermDepositFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of TermDepositFeatures  ***********************/
	class TermDepositFeaturesImpl implements TermDepositFeatures {
		private final DualCurrencyFeature dualCurrency;
		
		protected TermDepositFeaturesImpl(TermDepositFeatures.TermDepositFeaturesBuilder builder) {
			this.dualCurrency = ofNullable(builder.getDualCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dualCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dualCurrency")
		public DualCurrencyFeature getDualCurrency() {
			return dualCurrency;
		}
		
		@Override
		public TermDepositFeatures build() {
			return this;
		}
		
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder toBuilder() {
			TermDepositFeatures.TermDepositFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermDepositFeatures.TermDepositFeaturesBuilder builder) {
			ofNullable(getDualCurrency()).ifPresent(builder::setDualCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermDepositFeatures _that = getType().cast(o);
		
			if (!Objects.equals(dualCurrency, _that.getDualCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dualCurrency != null ? dualCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDepositFeatures {" +
				"dualCurrency=" + this.dualCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of TermDepositFeatures  ***********************/
	class TermDepositFeaturesBuilderImpl implements TermDepositFeatures.TermDepositFeaturesBuilder {
	
		protected DualCurrencyFeature.DualCurrencyFeatureBuilder dualCurrency;
		
		@Override
		@RosettaAttribute("dualCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dualCurrency")
		public DualCurrencyFeature.DualCurrencyFeatureBuilder getDualCurrency() {
			return dualCurrency;
		}
		
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder getOrCreateDualCurrency() {
			DualCurrencyFeature.DualCurrencyFeatureBuilder result;
			if (dualCurrency!=null) {
				result = dualCurrency;
			}
			else {
				result = dualCurrency = DualCurrencyFeature.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dualCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dualCurrency")
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder setDualCurrency(DualCurrencyFeature _dualCurrency) {
			this.dualCurrency = _dualCurrency == null ? null : _dualCurrency.toBuilder();
			return this;
		}
		
		@Override
		public TermDepositFeatures build() {
			return new TermDepositFeatures.TermDepositFeaturesImpl(this);
		}
		
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder prune() {
			if (dualCurrency!=null && !dualCurrency.prune().hasData()) dualCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDualCurrency()!=null && getDualCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TermDepositFeatures.TermDepositFeaturesBuilder o = (TermDepositFeatures.TermDepositFeaturesBuilder) other;
			
			merger.mergeRosetta(getDualCurrency(), o.getDualCurrency(), this::setDualCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermDepositFeatures _that = getType().cast(o);
		
			if (!Objects.equals(dualCurrency, _that.getDualCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dualCurrency != null ? dualCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDepositFeaturesBuilder {" +
				"dualCurrency=" + this.dualCurrency +
			'}';
		}
	}
}
