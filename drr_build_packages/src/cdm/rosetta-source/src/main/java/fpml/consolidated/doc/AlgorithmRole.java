package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.AlgorithmRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing a role played by an algorithm in one or more transactions. Examples include roles such as TradingDecision, RoutingDecision. This can be extended to provide custom roles.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a role played by an algorithm in one or more transactions. Examples include roles such as TradingDecision, RoutingDecision. This can be extended to provide custom roles.
 *
 */
@RosettaDataType(value="AlgorithmRole", builder=AlgorithmRole.AlgorithmRoleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AlgorithmRole", model="fpml", builder=AlgorithmRole.AlgorithmRoleBuilderImpl.class, version="2.1.1")
public interface AlgorithmRole extends RosettaModelObject {

	AlgorithmRoleMeta metaData = new AlgorithmRoleMeta();

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
	String getAlgorithmRoleScheme();

	/*********************** Build Methods  ***********************/
	AlgorithmRole build();
	
	AlgorithmRole.AlgorithmRoleBuilder toBuilder();
	
	static AlgorithmRole.AlgorithmRoleBuilder builder() {
		return new AlgorithmRole.AlgorithmRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AlgorithmRole> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AlgorithmRole> getType() {
		return AlgorithmRole.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("algorithmRoleScheme"), String.class, getAlgorithmRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AlgorithmRoleBuilder extends AlgorithmRole, RosettaModelObjectBuilder {
		AlgorithmRole.AlgorithmRoleBuilder setValue(String value);
		AlgorithmRole.AlgorithmRoleBuilder setAlgorithmRoleScheme(String algorithmRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("algorithmRoleScheme"), String.class, getAlgorithmRoleScheme(), this);
		}
		

		AlgorithmRole.AlgorithmRoleBuilder prune();
	}

	/*********************** Immutable Implementation of AlgorithmRole  ***********************/
	class AlgorithmRoleImpl implements AlgorithmRole {
		private final String value;
		private final String algorithmRoleScheme;
		
		protected AlgorithmRoleImpl(AlgorithmRole.AlgorithmRoleBuilder builder) {
			this.value = builder.getValue();
			this.algorithmRoleScheme = builder.getAlgorithmRoleScheme();
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
		@RosettaAttribute("algorithmRoleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("algorithmRoleScheme")
		public String getAlgorithmRoleScheme() {
			return algorithmRoleScheme;
		}
		
		@Override
		public AlgorithmRole build() {
			return this;
		}
		
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder toBuilder() {
			AlgorithmRole.AlgorithmRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AlgorithmRole.AlgorithmRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAlgorithmRoleScheme()).ifPresent(builder::setAlgorithmRoleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AlgorithmRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(algorithmRoleScheme, _that.getAlgorithmRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (algorithmRoleScheme != null ? algorithmRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AlgorithmRole {" +
				"value=" + this.value + ", " +
				"algorithmRoleScheme=" + this.algorithmRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AlgorithmRole  ***********************/
	class AlgorithmRoleBuilderImpl implements AlgorithmRole.AlgorithmRoleBuilder {
	
		protected String value;
		protected String algorithmRoleScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("algorithmRoleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("algorithmRoleScheme")
		public String getAlgorithmRoleScheme() {
			return algorithmRoleScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("algorithmRoleScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("algorithmRoleScheme")
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder setAlgorithmRoleScheme(String _algorithmRoleScheme) {
			this.algorithmRoleScheme = _algorithmRoleScheme == null ? null : _algorithmRoleScheme;
			return this;
		}
		
		@Override
		public AlgorithmRole build() {
			return new AlgorithmRole.AlgorithmRoleImpl(this);
		}
		
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAlgorithmRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AlgorithmRole.AlgorithmRoleBuilder o = (AlgorithmRole.AlgorithmRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAlgorithmRoleScheme(), o.getAlgorithmRoleScheme(), this::setAlgorithmRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AlgorithmRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(algorithmRoleScheme, _that.getAlgorithmRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (algorithmRoleScheme != null ? algorithmRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AlgorithmRoleBuilder {" +
				"value=" + this.value + ", " +
				"algorithmRoleScheme=" + this.algorithmRoleScheme +
			'}';
		}
	}
}
