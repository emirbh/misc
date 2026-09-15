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
import fpml.consolidated.shared.meta.OrganizationIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for a generic, user-defined identifier for an organization, where a full party structure is not desired or required.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for a generic, user-defined identifier for an organization, where a full party structure is not desired or required.
 *
 */
@RosettaDataType(value="OrganizationIdentifier", builder=OrganizationIdentifier.OrganizationIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OrganizationIdentifier", model="fpml", builder=OrganizationIdentifier.OrganizationIdentifierBuilderImpl.class, version="2.1.1")
public interface OrganizationIdentifier extends RosettaModelObject {

	OrganizationIdentifierMeta metaData = new OrganizationIdentifierMeta();

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
	 * Provision The identifier scheme used with this generic identifier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used with this generic identifier.
	 *
	 */
	String getIdScheme();

	/*********************** Build Methods  ***********************/
	OrganizationIdentifier build();
	
	OrganizationIdentifier.OrganizationIdentifierBuilder toBuilder();
	
	static OrganizationIdentifier.OrganizationIdentifierBuilder builder() {
		return new OrganizationIdentifier.OrganizationIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganizationIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganizationIdentifier> getType() {
		return OrganizationIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("idScheme"), String.class, getIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganizationIdentifierBuilder extends OrganizationIdentifier, RosettaModelObjectBuilder {
		OrganizationIdentifier.OrganizationIdentifierBuilder setValue(String value);
		OrganizationIdentifier.OrganizationIdentifierBuilder setIdScheme(String idScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("idScheme"), String.class, getIdScheme(), this);
		}
		

		OrganizationIdentifier.OrganizationIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of OrganizationIdentifier  ***********************/
	class OrganizationIdentifierImpl implements OrganizationIdentifier {
		private final String value;
		private final String idScheme;
		
		protected OrganizationIdentifierImpl(OrganizationIdentifier.OrganizationIdentifierBuilder builder) {
			this.value = builder.getValue();
			this.idScheme = builder.getIdScheme();
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
		@RosettaAttribute("idScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("idScheme")
		public String getIdScheme() {
			return idScheme;
		}
		
		@Override
		public OrganizationIdentifier build() {
			return this;
		}
		
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder toBuilder() {
			OrganizationIdentifier.OrganizationIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganizationIdentifier.OrganizationIdentifierBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIdScheme()).ifPresent(builder::setIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(idScheme, _that.getIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (idScheme != null ? idScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationIdentifier {" +
				"value=" + this.value + ", " +
				"idScheme=" + this.idScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganizationIdentifier  ***********************/
	class OrganizationIdentifierBuilderImpl implements OrganizationIdentifier.OrganizationIdentifierBuilder {
	
		protected String value;
		protected String idScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("idScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("idScheme")
		public String getIdScheme() {
			return idScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("idScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("idScheme")
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder setIdScheme(String _idScheme) {
			this.idScheme = _idScheme == null ? null : _idScheme;
			return this;
		}
		
		@Override
		public OrganizationIdentifier build() {
			return new OrganizationIdentifier.OrganizationIdentifierImpl(this);
		}
		
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganizationIdentifier.OrganizationIdentifierBuilder o = (OrganizationIdentifier.OrganizationIdentifierBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIdScheme(), o.getIdScheme(), this::setIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(idScheme, _that.getIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (idScheme != null ? idScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationIdentifierBuilder {" +
				"value=" + this.value + ", " +
				"idScheme=" + this.idScheme +
			'}';
		}
	}
}
