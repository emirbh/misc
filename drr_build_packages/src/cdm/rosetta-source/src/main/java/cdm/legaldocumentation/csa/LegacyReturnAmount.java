package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyReturnAmountMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * In respect of a Valuation Date, the amount of collateral which a party is entitled to demand to be recalled to it as a Return Amount.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyReturnAmount", builder=LegacyReturnAmount.LegacyReturnAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyReturnAmount", model="cdm", builder=LegacyReturnAmount.LegacyReturnAmountBuilderImpl.class, version="6.23.0")
public interface LegacyReturnAmount extends RosettaModelObject {

	LegacyReturnAmountMeta metaData = new LegacyReturnAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the meaning of Return Amount follows the pre-print definition or deviates from this (either based on a rating or some other methodology).
	 */
	LegacyDeliveryReturnAmountEnum getLegacyReturnAmount();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyReturnAmount build();
	
	LegacyReturnAmount.LegacyReturnAmountBuilder toBuilder();
	
	static LegacyReturnAmount.LegacyReturnAmountBuilder builder() {
		return new LegacyReturnAmount.LegacyReturnAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyReturnAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyReturnAmount> getType() {
		return LegacyReturnAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("legacyReturnAmount"), LegacyDeliveryReturnAmountEnum.class, getLegacyReturnAmount(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyReturnAmountBuilder extends LegacyReturnAmount, RosettaModelObjectBuilder {
		LegacyReturnAmount.LegacyReturnAmountBuilder setLegacyReturnAmount(LegacyDeliveryReturnAmountEnum legacyReturnAmount);
		LegacyReturnAmount.LegacyReturnAmountBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("legacyReturnAmount"), LegacyDeliveryReturnAmountEnum.class, getLegacyReturnAmount(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyReturnAmount.LegacyReturnAmountBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyReturnAmount  ***********************/
	class LegacyReturnAmountImpl implements LegacyReturnAmount {
		private final LegacyDeliveryReturnAmountEnum legacyReturnAmount;
		private final String additionalLanguage;
		
		protected LegacyReturnAmountImpl(LegacyReturnAmount.LegacyReturnAmountBuilder builder) {
			this.legacyReturnAmount = builder.getLegacyReturnAmount();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		public LegacyDeliveryReturnAmountEnum getLegacyReturnAmount() {
			return legacyReturnAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyReturnAmount build() {
			return this;
		}
		
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder toBuilder() {
			LegacyReturnAmount.LegacyReturnAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyReturnAmount.LegacyReturnAmountBuilder builder) {
			ofNullable(getLegacyReturnAmount()).ifPresent(builder::setLegacyReturnAmount);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyReturnAmount _that = getType().cast(o);
		
			if (!Objects.equals(legacyReturnAmount, _that.getLegacyReturnAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legacyReturnAmount != null ? legacyReturnAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyReturnAmount {" +
				"legacyReturnAmount=" + this.legacyReturnAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyReturnAmount  ***********************/
	class LegacyReturnAmountBuilderImpl implements LegacyReturnAmount.LegacyReturnAmountBuilder {
	
		protected LegacyDeliveryReturnAmountEnum legacyReturnAmount;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		public LegacyDeliveryReturnAmountEnum getLegacyReturnAmount() {
			return legacyReturnAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder setLegacyReturnAmount(LegacyDeliveryReturnAmountEnum _legacyReturnAmount) {
			this.legacyReturnAmount = _legacyReturnAmount == null ? null : _legacyReturnAmount;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyReturnAmount build() {
			return new LegacyReturnAmount.LegacyReturnAmountImpl(this);
		}
		
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegacyReturnAmount()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyReturnAmount.LegacyReturnAmountBuilder o = (LegacyReturnAmount.LegacyReturnAmountBuilder) other;
			
			
			merger.mergeBasic(getLegacyReturnAmount(), o.getLegacyReturnAmount(), this::setLegacyReturnAmount);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyReturnAmount _that = getType().cast(o);
		
			if (!Objects.equals(legacyReturnAmount, _that.getLegacyReturnAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legacyReturnAmount != null ? legacyReturnAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyReturnAmountBuilder {" +
				"legacyReturnAmount=" + this.legacyReturnAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
