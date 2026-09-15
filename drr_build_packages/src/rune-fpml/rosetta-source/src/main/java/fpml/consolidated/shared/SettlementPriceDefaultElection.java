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
import fpml.consolidated.shared.meta.SettlementPriceDefaultElectionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Coding scheme that specifies the settlement price default election.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Coding scheme that specifies the settlement price default election.
 *
 */
@RosettaDataType(value="SettlementPriceDefaultElection", builder=SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPriceDefaultElection", model="fpml", builder=SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilderImpl.class, version="2.1.1")
public interface SettlementPriceDefaultElection extends RosettaModelObject {

	SettlementPriceDefaultElectionMeta metaData = new SettlementPriceDefaultElectionMeta();

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
	String getSettlementPriceDefaultElectionScheme();

	/*********************** Build Methods  ***********************/
	SettlementPriceDefaultElection build();
	
	SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder toBuilder();
	
	static SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder builder() {
		return new SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPriceDefaultElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPriceDefaultElection> getType() {
		return SettlementPriceDefaultElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementPriceDefaultElectionScheme"), String.class, getSettlementPriceDefaultElectionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPriceDefaultElectionBuilder extends SettlementPriceDefaultElection, RosettaModelObjectBuilder {
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder setValue(String value);
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder setSettlementPriceDefaultElectionScheme(String settlementPriceDefaultElectionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementPriceDefaultElectionScheme"), String.class, getSettlementPriceDefaultElectionScheme(), this);
		}
		

		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPriceDefaultElection  ***********************/
	class SettlementPriceDefaultElectionImpl implements SettlementPriceDefaultElection {
		private final String value;
		private final String settlementPriceDefaultElectionScheme;
		
		protected SettlementPriceDefaultElectionImpl(SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder builder) {
			this.value = builder.getValue();
			this.settlementPriceDefaultElectionScheme = builder.getSettlementPriceDefaultElectionScheme();
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
		@RosettaAttribute("settlementPriceDefaultElectionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceDefaultElectionScheme")
		public String getSettlementPriceDefaultElectionScheme() {
			return settlementPriceDefaultElectionScheme;
		}
		
		@Override
		public SettlementPriceDefaultElection build() {
			return this;
		}
		
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder toBuilder() {
			SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementPriceDefaultElectionScheme()).ifPresent(builder::setSettlementPriceDefaultElectionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPriceDefaultElection _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementPriceDefaultElectionScheme, _that.getSettlementPriceDefaultElectionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElectionScheme != null ? settlementPriceDefaultElectionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPriceDefaultElection {" +
				"value=" + this.value + ", " +
				"settlementPriceDefaultElectionScheme=" + this.settlementPriceDefaultElectionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPriceDefaultElection  ***********************/
	class SettlementPriceDefaultElectionBuilderImpl implements SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder {
	
		protected String value;
		protected String settlementPriceDefaultElectionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementPriceDefaultElectionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceDefaultElectionScheme")
		public String getSettlementPriceDefaultElectionScheme() {
			return settlementPriceDefaultElectionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settlementPriceDefaultElectionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPriceDefaultElectionScheme")
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder setSettlementPriceDefaultElectionScheme(String _settlementPriceDefaultElectionScheme) {
			this.settlementPriceDefaultElectionScheme = _settlementPriceDefaultElectionScheme == null ? null : _settlementPriceDefaultElectionScheme;
			return this;
		}
		
		@Override
		public SettlementPriceDefaultElection build() {
			return new SettlementPriceDefaultElection.SettlementPriceDefaultElectionImpl(this);
		}
		
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementPriceDefaultElectionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder o = (SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementPriceDefaultElectionScheme(), o.getSettlementPriceDefaultElectionScheme(), this::setSettlementPriceDefaultElectionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPriceDefaultElection _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementPriceDefaultElectionScheme, _that.getSettlementPriceDefaultElectionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElectionScheme != null ? settlementPriceDefaultElectionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPriceDefaultElectionBuilder {" +
				"value=" + this.value + ", " +
				"settlementPriceDefaultElectionScheme=" + this.settlementPriceDefaultElectionScheme +
			'}';
		}
	}
}
