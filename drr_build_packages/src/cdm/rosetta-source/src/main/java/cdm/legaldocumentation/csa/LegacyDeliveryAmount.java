package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyDeliveryAmountMeta;
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
 * In respect of a Valuation Date, the amount of collateral which a party is entitled to demand to be transferred to it as a Delivery Amount.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyDeliveryAmount", builder=LegacyDeliveryAmount.LegacyDeliveryAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyDeliveryAmount", model="cdm", builder=LegacyDeliveryAmount.LegacyDeliveryAmountBuilderImpl.class, version="6.23.0")
public interface LegacyDeliveryAmount extends RosettaModelObject {

	LegacyDeliveryAmountMeta metaData = new LegacyDeliveryAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the meaning of Delivery Amount follows the pre-print definition or deviates from this (either based on a rating or some other methodology).
	 */
	LegacyDeliveryReturnAmountEnum getLegacyDeliveryAmount();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyDeliveryAmount build();
	
	LegacyDeliveryAmount.LegacyDeliveryAmountBuilder toBuilder();
	
	static LegacyDeliveryAmount.LegacyDeliveryAmountBuilder builder() {
		return new LegacyDeliveryAmount.LegacyDeliveryAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyDeliveryAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyDeliveryAmount> getType() {
		return LegacyDeliveryAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("legacyDeliveryAmount"), LegacyDeliveryReturnAmountEnum.class, getLegacyDeliveryAmount(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyDeliveryAmountBuilder extends LegacyDeliveryAmount, RosettaModelObjectBuilder {
		LegacyDeliveryAmount.LegacyDeliveryAmountBuilder setLegacyDeliveryAmount(LegacyDeliveryReturnAmountEnum legacyDeliveryAmount);
		LegacyDeliveryAmount.LegacyDeliveryAmountBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("legacyDeliveryAmount"), LegacyDeliveryReturnAmountEnum.class, getLegacyDeliveryAmount(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyDeliveryAmount.LegacyDeliveryAmountBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyDeliveryAmount  ***********************/
	class LegacyDeliveryAmountImpl implements LegacyDeliveryAmount {
		private final LegacyDeliveryReturnAmountEnum legacyDeliveryAmount;
		private final String additionalLanguage;
		
		protected LegacyDeliveryAmountImpl(LegacyDeliveryAmount.LegacyDeliveryAmountBuilder builder) {
			this.legacyDeliveryAmount = builder.getLegacyDeliveryAmount();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		public LegacyDeliveryReturnAmountEnum getLegacyDeliveryAmount() {
			return legacyDeliveryAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyDeliveryAmount build() {
			return this;
		}
		
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder toBuilder() {
			LegacyDeliveryAmount.LegacyDeliveryAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyDeliveryAmount.LegacyDeliveryAmountBuilder builder) {
			ofNullable(getLegacyDeliveryAmount()).ifPresent(builder::setLegacyDeliveryAmount);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyDeliveryAmount _that = getType().cast(o);
		
			if (!Objects.equals(legacyDeliveryAmount, _that.getLegacyDeliveryAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legacyDeliveryAmount != null ? legacyDeliveryAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyDeliveryAmount {" +
				"legacyDeliveryAmount=" + this.legacyDeliveryAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyDeliveryAmount  ***********************/
	class LegacyDeliveryAmountBuilderImpl implements LegacyDeliveryAmount.LegacyDeliveryAmountBuilder {
	
		protected LegacyDeliveryReturnAmountEnum legacyDeliveryAmount;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		public LegacyDeliveryReturnAmountEnum getLegacyDeliveryAmount() {
			return legacyDeliveryAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder setLegacyDeliveryAmount(LegacyDeliveryReturnAmountEnum _legacyDeliveryAmount) {
			this.legacyDeliveryAmount = _legacyDeliveryAmount == null ? null : _legacyDeliveryAmount;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyDeliveryAmount build() {
			return new LegacyDeliveryAmount.LegacyDeliveryAmountImpl(this);
		}
		
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegacyDeliveryAmount()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyDeliveryAmount.LegacyDeliveryAmountBuilder o = (LegacyDeliveryAmount.LegacyDeliveryAmountBuilder) other;
			
			
			merger.mergeBasic(getLegacyDeliveryAmount(), o.getLegacyDeliveryAmount(), this::setLegacyDeliveryAmount);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyDeliveryAmount _that = getType().cast(o);
		
			if (!Objects.equals(legacyDeliveryAmount, _that.getLegacyDeliveryAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legacyDeliveryAmount != null ? legacyDeliveryAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyDeliveryAmountBuilder {" +
				"legacyDeliveryAmount=" + this.legacyDeliveryAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
