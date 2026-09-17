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
import fpml.consolidated.shared.meta.InformationProviderMeta;
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
@RosettaDataType(value="InformationProvider", builder=InformationProvider.InformationProviderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InformationProvider", model="fpml", builder=InformationProvider.InformationProviderBuilderImpl.class, version="2.1.1")
public interface InformationProvider extends RosettaModelObject {

	InformationProviderMeta metaData = new InformationProviderMeta();

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
	String getInformationProviderScheme();

	/*********************** Build Methods  ***********************/
	InformationProvider build();
	
	InformationProvider.InformationProviderBuilder toBuilder();
	
	static InformationProvider.InformationProviderBuilder builder() {
		return new InformationProvider.InformationProviderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InformationProvider> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InformationProvider> getType() {
		return InformationProvider.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InformationProviderBuilder extends InformationProvider, RosettaModelObjectBuilder {
		InformationProvider.InformationProviderBuilder setValue(String value);
		InformationProvider.InformationProviderBuilder setInformationProviderScheme(String informationProviderScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
		}
		

		InformationProvider.InformationProviderBuilder prune();
	}

	/*********************** Immutable Implementation of InformationProvider  ***********************/
	class InformationProviderImpl implements InformationProvider {
		private final String value;
		private final String informationProviderScheme;
		
		protected InformationProviderImpl(InformationProvider.InformationProviderBuilder builder) {
			this.value = builder.getValue();
			this.informationProviderScheme = builder.getInformationProviderScheme();
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
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@Override
		public InformationProvider build() {
			return this;
		}
		
		@Override
		public InformationProvider.InformationProviderBuilder toBuilder() {
			InformationProvider.InformationProviderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InformationProvider.InformationProviderBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInformationProviderScheme()).ifPresent(builder::setInformationProviderScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationProvider {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of InformationProvider  ***********************/
	class InformationProviderBuilderImpl implements InformationProvider.InformationProviderBuilder {
	
		protected String value;
		protected String informationProviderScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public InformationProvider.InformationProviderBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationProviderScheme")
		@Override
		public InformationProvider.InformationProviderBuilder setInformationProviderScheme(String _informationProviderScheme) {
			this.informationProviderScheme = _informationProviderScheme == null ? null : _informationProviderScheme;
			return this;
		}
		
		@Override
		public InformationProvider build() {
			return new InformationProvider.InformationProviderImpl(this);
		}
		
		@Override
		public InformationProvider.InformationProviderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationProvider.InformationProviderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInformationProviderScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationProvider.InformationProviderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InformationProvider.InformationProviderBuilder o = (InformationProvider.InformationProviderBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInformationProviderScheme(), o.getInformationProviderScheme(), this::setInformationProviderScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationProviderBuilder {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}
}
