package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BenchmarkRateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for a benchmark rate (e.g. agreed discount rate or collateral interest rate).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for a benchmark rate (e.g. agreed discount rate or collateral interest rate).
 *
 */
@RosettaDataType(value="BenchmarkRate", builder=BenchmarkRate.BenchmarkRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BenchmarkRate", model="fpml", builder=BenchmarkRate.BenchmarkRateBuilderImpl.class, version="2.1.1")
public interface BenchmarkRate extends RosettaModelObject {

	BenchmarkRateMeta metaData = new BenchmarkRateMeta();

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
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The identifier scheme used for this benchmark. This will be defaulted to an ISDA benchmark scheme.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used for this benchmark. This will be defaulted to an ISDA benchmark scheme.
	 *
	 */
	String getBenchmarkRateScheme();

	/*********************** Build Methods  ***********************/
	BenchmarkRate build();
	
	BenchmarkRate.BenchmarkRateBuilder toBuilder();
	
	static BenchmarkRate.BenchmarkRateBuilder builder() {
		return new BenchmarkRate.BenchmarkRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BenchmarkRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BenchmarkRate> getType() {
		return BenchmarkRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("benchmarkRateScheme"), String.class, getBenchmarkRateScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BenchmarkRateBuilder extends BenchmarkRate, RosettaModelObjectBuilder {
		BenchmarkRate.BenchmarkRateBuilder setValue(String value);
		BenchmarkRate.BenchmarkRateBuilder setBenchmarkRateScheme(String benchmarkRateScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("benchmarkRateScheme"), String.class, getBenchmarkRateScheme(), this);
		}
		

		BenchmarkRate.BenchmarkRateBuilder prune();
	}

	/*********************** Immutable Implementation of BenchmarkRate  ***********************/
	class BenchmarkRateImpl implements BenchmarkRate {
		private final String value;
		private final String benchmarkRateScheme;
		
		protected BenchmarkRateImpl(BenchmarkRate.BenchmarkRateBuilder builder) {
			this.value = builder.getValue();
			this.benchmarkRateScheme = builder.getBenchmarkRateScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("benchmarkRateScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkRateScheme")
		public String getBenchmarkRateScheme() {
			return benchmarkRateScheme;
		}
		
		@Override
		public BenchmarkRate build() {
			return this;
		}
		
		@Override
		public BenchmarkRate.BenchmarkRateBuilder toBuilder() {
			BenchmarkRate.BenchmarkRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BenchmarkRate.BenchmarkRateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBenchmarkRateScheme()).ifPresent(builder::setBenchmarkRateScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BenchmarkRate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(benchmarkRateScheme, _that.getBenchmarkRateScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (benchmarkRateScheme != null ? benchmarkRateScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BenchmarkRate {" +
				"value=" + this.value + ", " +
				"benchmarkRateScheme=" + this.benchmarkRateScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BenchmarkRate  ***********************/
	class BenchmarkRateBuilderImpl implements BenchmarkRate.BenchmarkRateBuilder {
	
		protected String value;
		protected String benchmarkRateScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("benchmarkRateScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkRateScheme")
		public String getBenchmarkRateScheme() {
			return benchmarkRateScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public BenchmarkRate.BenchmarkRateBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("benchmarkRateScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("benchmarkRateScheme")
		@Override
		public BenchmarkRate.BenchmarkRateBuilder setBenchmarkRateScheme(String _benchmarkRateScheme) {
			this.benchmarkRateScheme = _benchmarkRateScheme == null ? null : _benchmarkRateScheme;
			return this;
		}
		
		@Override
		public BenchmarkRate build() {
			return new BenchmarkRate.BenchmarkRateImpl(this);
		}
		
		@Override
		public BenchmarkRate.BenchmarkRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BenchmarkRate.BenchmarkRateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBenchmarkRateScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BenchmarkRate.BenchmarkRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BenchmarkRate.BenchmarkRateBuilder o = (BenchmarkRate.BenchmarkRateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBenchmarkRateScheme(), o.getBenchmarkRateScheme(), this::setBenchmarkRateScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BenchmarkRate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(benchmarkRateScheme, _that.getBenchmarkRateScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (benchmarkRateScheme != null ? benchmarkRateScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BenchmarkRateBuilder {" +
				"value=" + this.value + ", " +
				"benchmarkRateScheme=" + this.benchmarkRateScheme +
			'}';
		}
	}
}
