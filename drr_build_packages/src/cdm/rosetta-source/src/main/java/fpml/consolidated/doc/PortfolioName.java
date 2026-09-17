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
import fpml.consolidated.doc.meta.PortfolioNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for portfolio names.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for portfolio names.
 *
 */
@RosettaDataType(value="PortfolioName", builder=PortfolioName.PortfolioNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PortfolioName", model="fpml", builder=PortfolioName.PortfolioNameBuilderImpl.class, version="2.1.1")
public interface PortfolioName extends RosettaModelObject {

	PortfolioNameMeta metaData = new PortfolioNameMeta();

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
	String getId();
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
	String getPortfolioNameScheme();

	/*********************** Build Methods  ***********************/
	PortfolioName build();
	
	PortfolioName.PortfolioNameBuilder toBuilder();
	
	static PortfolioName.PortfolioNameBuilder builder() {
		return new PortfolioName.PortfolioNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioName> getType() {
		return PortfolioName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("portfolioNameScheme"), String.class, getPortfolioNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioNameBuilder extends PortfolioName, RosettaModelObjectBuilder {
		PortfolioName.PortfolioNameBuilder setValue(String value);
		PortfolioName.PortfolioNameBuilder setId(String id);
		PortfolioName.PortfolioNameBuilder setPortfolioNameScheme(String portfolioNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("portfolioNameScheme"), String.class, getPortfolioNameScheme(), this);
		}
		

		PortfolioName.PortfolioNameBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioName  ***********************/
	class PortfolioNameImpl implements PortfolioName {
		private final String value;
		private final String id;
		private final String portfolioNameScheme;
		
		protected PortfolioNameImpl(PortfolioName.PortfolioNameBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
			this.portfolioNameScheme = builder.getPortfolioNameScheme();
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
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("portfolioNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioNameScheme")
		public String getPortfolioNameScheme() {
			return portfolioNameScheme;
		}
		
		@Override
		public PortfolioName build() {
			return this;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder toBuilder() {
			PortfolioName.PortfolioNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioName.PortfolioNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPortfolioNameScheme()).ifPresent(builder::setPortfolioNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(portfolioNameScheme, _that.getPortfolioNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (portfolioNameScheme != null ? portfolioNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioName {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"portfolioNameScheme=" + this.portfolioNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioName  ***********************/
	class PortfolioNameBuilderImpl implements PortfolioName.PortfolioNameBuilder {
	
		protected String value;
		protected String id;
		protected String portfolioNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("portfolioNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioNameScheme")
		public String getPortfolioNameScheme() {
			return portfolioNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PortfolioName.PortfolioNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PortfolioName.PortfolioNameBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("portfolioNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioNameScheme")
		@Override
		public PortfolioName.PortfolioNameBuilder setPortfolioNameScheme(String _portfolioNameScheme) {
			this.portfolioNameScheme = _portfolioNameScheme == null ? null : _portfolioNameScheme;
			return this;
		}
		
		@Override
		public PortfolioName build() {
			return new PortfolioName.PortfolioNameImpl(this);
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioName.PortfolioNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			if (getPortfolioNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioName.PortfolioNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioName.PortfolioNameBuilder o = (PortfolioName.PortfolioNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPortfolioNameScheme(), o.getPortfolioNameScheme(), this::setPortfolioNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(portfolioNameScheme, _that.getPortfolioNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (portfolioNameScheme != null ? portfolioNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioNameBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"portfolioNameScheme=" + this.portfolioNameScheme +
			'}';
		}
	}
}
