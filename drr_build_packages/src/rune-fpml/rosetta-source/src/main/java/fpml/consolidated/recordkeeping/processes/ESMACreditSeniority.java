package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.ESMACreditSeniorityMeta;
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
 */
@RosettaDataType(value="ESMACreditSeniority", builder=ESMACreditSeniority.ESMACreditSeniorityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMACreditSeniority", model="fpml", builder=ESMACreditSeniority.ESMACreditSeniorityBuilderImpl.class, version="2.1.1")
public interface ESMACreditSeniority extends RosettaModelObject {

	ESMACreditSeniorityMeta metaData = new ESMACreditSeniorityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	String getCreditSeniorityScheme();

	/*********************** Build Methods  ***********************/
	ESMACreditSeniority build();
	
	ESMACreditSeniority.ESMACreditSeniorityBuilder toBuilder();
	
	static ESMACreditSeniority.ESMACreditSeniorityBuilder builder() {
		return new ESMACreditSeniority.ESMACreditSeniorityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMACreditSeniority> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMACreditSeniority> getType() {
		return ESMACreditSeniority.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditSeniorityScheme"), String.class, getCreditSeniorityScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMACreditSeniorityBuilder extends ESMACreditSeniority, RosettaModelObjectBuilder {
		ESMACreditSeniority.ESMACreditSeniorityBuilder setValue(String value);
		ESMACreditSeniority.ESMACreditSeniorityBuilder setCreditSeniorityScheme(String creditSeniorityScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditSeniorityScheme"), String.class, getCreditSeniorityScheme(), this);
		}
		

		ESMACreditSeniority.ESMACreditSeniorityBuilder prune();
	}

	/*********************** Immutable Implementation of ESMACreditSeniority  ***********************/
	class ESMACreditSeniorityImpl implements ESMACreditSeniority {
		private final String value;
		private final String creditSeniorityScheme;
		
		protected ESMACreditSeniorityImpl(ESMACreditSeniority.ESMACreditSeniorityBuilder builder) {
			this.value = builder.getValue();
			this.creditSeniorityScheme = builder.getCreditSeniorityScheme();
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
		@RosettaAttribute("creditSeniorityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSeniorityScheme")
		public String getCreditSeniorityScheme() {
			return creditSeniorityScheme;
		}
		
		@Override
		public ESMACreditSeniority build() {
			return this;
		}
		
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder toBuilder() {
			ESMACreditSeniority.ESMACreditSeniorityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMACreditSeniority.ESMACreditSeniorityBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditSeniorityScheme()).ifPresent(builder::setCreditSeniorityScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMACreditSeniority _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSeniorityScheme, _that.getCreditSeniorityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSeniorityScheme != null ? creditSeniorityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMACreditSeniority {" +
				"value=" + this.value + ", " +
				"creditSeniorityScheme=" + this.creditSeniorityScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMACreditSeniority  ***********************/
	class ESMACreditSeniorityBuilderImpl implements ESMACreditSeniority.ESMACreditSeniorityBuilder {
	
		protected String value;
		protected String creditSeniorityScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSeniorityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSeniorityScheme")
		public String getCreditSeniorityScheme() {
			return creditSeniorityScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("creditSeniorityScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditSeniorityScheme")
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder setCreditSeniorityScheme(String _creditSeniorityScheme) {
			this.creditSeniorityScheme = _creditSeniorityScheme == null ? null : _creditSeniorityScheme;
			return this;
		}
		
		@Override
		public ESMACreditSeniority build() {
			return new ESMACreditSeniority.ESMACreditSeniorityImpl(this);
		}
		
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditSeniorityScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMACreditSeniority.ESMACreditSeniorityBuilder o = (ESMACreditSeniority.ESMACreditSeniorityBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditSeniorityScheme(), o.getCreditSeniorityScheme(), this::setCreditSeniorityScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMACreditSeniority _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSeniorityScheme, _that.getCreditSeniorityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSeniorityScheme != null ? creditSeniorityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMACreditSeniorityBuilder {" +
				"value=" + this.value + ", " +
				"creditSeniorityScheme=" + this.creditSeniorityScheme +
			'}';
		}
	}
}
