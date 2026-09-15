package drr.regulation.common;

import cdm.event.common.Valuation;
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
import drr.regulation.common.meta.ValuationDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ValuationDetails", builder=ValuationDetails.ValuationDetailsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ValuationDetails", model="drr", builder=ValuationDetails.ValuationDetailsBuilderImpl.class, version="7.7.0")
public interface ValuationDetails extends RosettaModelObject {

	ValuationDetailsMeta metaData = new ValuationDetailsMeta();

	/*********************** Getter Methods  ***********************/
	Valuation getValuation();
	ValuationTradeInformation getTradeInformation();

	/*********************** Build Methods  ***********************/
	ValuationDetails build();
	
	ValuationDetails.ValuationDetailsBuilder toBuilder();
	
	static ValuationDetails.ValuationDetailsBuilder builder() {
		return new ValuationDetails.ValuationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationDetails> getType() {
		return ValuationDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuation"), processor, Valuation.class, getValuation());
		processRosetta(path.newSubPath("tradeInformation"), processor, ValuationTradeInformation.class, getTradeInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDetailsBuilder extends ValuationDetails, RosettaModelObjectBuilder {
		Valuation.ValuationBuilder getOrCreateValuation();
		@Override
		Valuation.ValuationBuilder getValuation();
		ValuationTradeInformation.ValuationTradeInformationBuilder getOrCreateTradeInformation();
		@Override
		ValuationTradeInformation.ValuationTradeInformationBuilder getTradeInformation();
		ValuationDetails.ValuationDetailsBuilder setValuation(Valuation valuation);
		ValuationDetails.ValuationDetailsBuilder setTradeInformation(ValuationTradeInformation tradeInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuation"), processor, Valuation.ValuationBuilder.class, getValuation());
			processRosetta(path.newSubPath("tradeInformation"), processor, ValuationTradeInformation.ValuationTradeInformationBuilder.class, getTradeInformation());
		}
		

		ValuationDetails.ValuationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDetails  ***********************/
	class ValuationDetailsImpl implements ValuationDetails {
		private final Valuation valuation;
		private final ValuationTradeInformation tradeInformation;
		
		protected ValuationDetailsImpl(ValuationDetails.ValuationDetailsBuilder builder) {
			this.valuation = ofNullable(builder.getValuation()).map(f->f.build()).orElse(null);
			this.tradeInformation = ofNullable(builder.getTradeInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuation")
		public Valuation getValuation() {
			return valuation;
		}
		
		@Override
		@RosettaAttribute("tradeInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeInformation")
		public ValuationTradeInformation getTradeInformation() {
			return tradeInformation;
		}
		
		@Override
		public ValuationDetails build() {
			return this;
		}
		
		@Override
		public ValuationDetails.ValuationDetailsBuilder toBuilder() {
			ValuationDetails.ValuationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDetails.ValuationDetailsBuilder builder) {
			ofNullable(getValuation()).ifPresent(builder::setValuation);
			ofNullable(getTradeInformation()).ifPresent(builder::setTradeInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDetails _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			if (!Objects.equals(tradeInformation, _that.getTradeInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			_result = 31 * _result + (tradeInformation != null ? tradeInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDetails {" +
				"valuation=" + this.valuation + ", " +
				"tradeInformation=" + this.tradeInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationDetails  ***********************/
	class ValuationDetailsBuilderImpl implements ValuationDetails.ValuationDetailsBuilder {
	
		protected Valuation.ValuationBuilder valuation;
		protected ValuationTradeInformation.ValuationTradeInformationBuilder tradeInformation;
		
		@Override
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuation")
		public Valuation.ValuationBuilder getValuation() {
			return valuation;
		}
		
		@Override
		public Valuation.ValuationBuilder getOrCreateValuation() {
			Valuation.ValuationBuilder result;
			if (valuation!=null) {
				result = valuation;
			}
			else {
				result = valuation = Valuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeInformation")
		public ValuationTradeInformation.ValuationTradeInformationBuilder getTradeInformation() {
			return tradeInformation;
		}
		
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder getOrCreateTradeInformation() {
			ValuationTradeInformation.ValuationTradeInformationBuilder result;
			if (tradeInformation!=null) {
				result = tradeInformation;
			}
			else {
				result = tradeInformation = ValuationTradeInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuation")
		@Override
		public ValuationDetails.ValuationDetailsBuilder setValuation(Valuation _valuation) {
			this.valuation = _valuation == null ? null : _valuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeInformation")
		@Override
		public ValuationDetails.ValuationDetailsBuilder setTradeInformation(ValuationTradeInformation _tradeInformation) {
			this.tradeInformation = _tradeInformation == null ? null : _tradeInformation.toBuilder();
			return this;
		}
		
		@Override
		public ValuationDetails build() {
			return new ValuationDetails.ValuationDetailsImpl(this);
		}
		
		@Override
		public ValuationDetails.ValuationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDetails.ValuationDetailsBuilder prune() {
			if (valuation!=null && !valuation.prune().hasData()) valuation = null;
			if (tradeInformation!=null && !tradeInformation.prune().hasData()) tradeInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuation()!=null && getValuation().hasData()) return true;
			if (getTradeInformation()!=null && getTradeInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDetails.ValuationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationDetails.ValuationDetailsBuilder o = (ValuationDetails.ValuationDetailsBuilder) other;
			
			merger.mergeRosetta(getValuation(), o.getValuation(), this::setValuation);
			merger.mergeRosetta(getTradeInformation(), o.getTradeInformation(), this::setTradeInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDetails _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			if (!Objects.equals(tradeInformation, _that.getTradeInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			_result = 31 * _result + (tradeInformation != null ? tradeInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDetailsBuilder {" +
				"valuation=" + this.valuation + ", " +
				"tradeInformation=" + this.tradeInformation +
			'}';
		}
	}
}
