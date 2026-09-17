package fpml.consolidated.fx;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.meta.DualExchangeRateMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision If present indicates that the event is considered to have occured if two or more numeric values of currency exchange rate specified in the Settllement Option are applicable to the transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision If present indicates that the event is considered to have occured if two or more numeric values of currency exchange rate specified in the Settllement Option are applicable to the transaction.
 *
 */
@RosettaDataType(value="DualExchangeRate", builder=DualExchangeRate.DualExchangeRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DualExchangeRate", model="fpml", builder=DualExchangeRate.DualExchangeRateBuilderImpl.class, version="2.1.1")
public interface DualExchangeRate extends FxDisruptionEvent {

	DualExchangeRateMeta metaData = new DualExchangeRateMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DualExchangeRate build();
	
	DualExchangeRate.DualExchangeRateBuilder toBuilder();
	
	static DualExchangeRate.DualExchangeRateBuilder builder() {
		return new DualExchangeRate.DualExchangeRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DualExchangeRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DualExchangeRate> getType() {
		return DualExchangeRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface DualExchangeRateBuilder extends DualExchangeRate, FxDisruptionEvent.FxDisruptionEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		DualExchangeRate.DualExchangeRateBuilder prune();
	}

	/*********************** Immutable Implementation of DualExchangeRate  ***********************/
	class DualExchangeRateImpl extends FxDisruptionEvent.FxDisruptionEventImpl implements DualExchangeRate {
		
		protected DualExchangeRateImpl(DualExchangeRate.DualExchangeRateBuilder builder) {
			super(builder);
		}
		
		@Override
		public DualExchangeRate build() {
			return this;
		}
		
		@Override
		public DualExchangeRate.DualExchangeRateBuilder toBuilder() {
			DualExchangeRate.DualExchangeRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DualExchangeRate.DualExchangeRateBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualExchangeRate {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DualExchangeRate  ***********************/
	class DualExchangeRateBuilderImpl extends FxDisruptionEvent.FxDisruptionEventBuilderImpl implements DualExchangeRate.DualExchangeRateBuilder {
	
		
		@Override
		public DualExchangeRate build() {
			return new DualExchangeRate.DualExchangeRateImpl(this);
		}
		
		@Override
		public DualExchangeRate.DualExchangeRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualExchangeRate.DualExchangeRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualExchangeRate.DualExchangeRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DualExchangeRate.DualExchangeRateBuilder o = (DualExchangeRate.DualExchangeRateBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualExchangeRateBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
