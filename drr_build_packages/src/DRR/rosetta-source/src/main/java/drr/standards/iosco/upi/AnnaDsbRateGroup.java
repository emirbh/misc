package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbRateGroupMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbRateGroup", builder=AnnaDsbRateGroup.AnnaDsbRateGroupBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbRateGroup", model="drr", builder=AnnaDsbRateGroup.AnnaDsbRateGroupBuilderImpl.class, version="7.7.0")
public interface AnnaDsbRateGroup extends RosettaModelObject {

	AnnaDsbRateGroupMeta metaData = new AnnaDsbRateGroupMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbRateDetail getRates();

	/*********************** Build Methods  ***********************/
	AnnaDsbRateGroup build();
	
	AnnaDsbRateGroup.AnnaDsbRateGroupBuilder toBuilder();
	
	static AnnaDsbRateGroup.AnnaDsbRateGroupBuilder builder() {
		return new AnnaDsbRateGroup.AnnaDsbRateGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbRateGroup> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbRateGroup> getType() {
		return AnnaDsbRateGroup.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Rates"), processor, AnnaDsbRateDetail.class, getRates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbRateGroupBuilder extends AnnaDsbRateGroup, RosettaModelObjectBuilder {
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder getOrCreateRates();
		@Override
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder getRates();
		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder setRates(AnnaDsbRateDetail Rates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Rates"), processor, AnnaDsbRateDetail.AnnaDsbRateDetailBuilder.class, getRates());
		}
		

		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbRateGroup  ***********************/
	class AnnaDsbRateGroupImpl implements AnnaDsbRateGroup {
		private final AnnaDsbRateDetail rates;
		
		protected AnnaDsbRateGroupImpl(AnnaDsbRateGroup.AnnaDsbRateGroupBuilder builder) {
			this.rates = ofNullable(builder.getRates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Rates")
		public AnnaDsbRateDetail getRates() {
			return rates;
		}
		
		@Override
		public AnnaDsbRateGroup build() {
			return this;
		}
		
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder toBuilder() {
			AnnaDsbRateGroup.AnnaDsbRateGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbRateGroup.AnnaDsbRateGroupBuilder builder) {
			ofNullable(getRates()).ifPresent(builder::setRates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRateGroup _that = getType().cast(o);
		
			if (!Objects.equals(rates, _that.getRates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rates != null ? rates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRateGroup {" +
				"Rates=" + this.rates +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbRateGroup  ***********************/
	class AnnaDsbRateGroupBuilderImpl implements AnnaDsbRateGroup.AnnaDsbRateGroupBuilder {
	
		protected AnnaDsbRateDetail.AnnaDsbRateDetailBuilder rates;
		
		@Override
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Rates")
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder getRates() {
			return rates;
		}
		
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder getOrCreateRates() {
			AnnaDsbRateDetail.AnnaDsbRateDetailBuilder result;
			if (rates!=null) {
				result = rates;
			}
			else {
				result = rates = AnnaDsbRateDetail.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Rates")
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder setRates(AnnaDsbRateDetail _rates) {
			this.rates = _rates == null ? null : _rates.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbRateGroup build() {
			return new AnnaDsbRateGroup.AnnaDsbRateGroupImpl(this);
		}
		
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder prune() {
			if (rates!=null && !rates.prune().hasData()) rates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRates()!=null && getRates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbRateGroup.AnnaDsbRateGroupBuilder o = (AnnaDsbRateGroup.AnnaDsbRateGroupBuilder) other;
			
			merger.mergeRosetta(getRates(), o.getRates(), this::setRates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRateGroup _that = getType().cast(o);
		
			if (!Objects.equals(rates, _that.getRates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rates != null ? rates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRateGroupBuilder {" +
				"Rates=" + this.rates +
			'}';
		}
	}
}
