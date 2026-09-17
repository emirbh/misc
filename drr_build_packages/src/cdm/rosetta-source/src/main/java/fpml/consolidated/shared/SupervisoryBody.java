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
import fpml.consolidated.shared.meta.SupervisoryBodyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An identifier of an organization that supervises or regulates trading activity, e.g. CFTC, SEC, FSA, ODRF, etc.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An identifier of an organization that supervises or regulates trading activity, e.g. CFTC, SEC, FSA, ODRF, etc.
 *
 */
@RosettaDataType(value="SupervisoryBody", builder=SupervisoryBody.SupervisoryBodyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SupervisoryBody", model="fpml", builder=SupervisoryBody.SupervisoryBodyBuilderImpl.class, version="2.1.1")
public interface SupervisoryBody extends RosettaModelObject {

	SupervisoryBodyMeta metaData = new SupervisoryBodyMeta();

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
	String getSupervisoryBodyScheme();

	/*********************** Build Methods  ***********************/
	SupervisoryBody build();
	
	SupervisoryBody.SupervisoryBodyBuilder toBuilder();
	
	static SupervisoryBody.SupervisoryBodyBuilder builder() {
		return new SupervisoryBody.SupervisoryBodyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupervisoryBody> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SupervisoryBody> getType() {
		return SupervisoryBody.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("supervisoryBodyScheme"), String.class, getSupervisoryBodyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupervisoryBodyBuilder extends SupervisoryBody, RosettaModelObjectBuilder {
		SupervisoryBody.SupervisoryBodyBuilder setValue(String value);
		SupervisoryBody.SupervisoryBodyBuilder setSupervisoryBodyScheme(String supervisoryBodyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("supervisoryBodyScheme"), String.class, getSupervisoryBodyScheme(), this);
		}
		

		SupervisoryBody.SupervisoryBodyBuilder prune();
	}

	/*********************** Immutable Implementation of SupervisoryBody  ***********************/
	class SupervisoryBodyImpl implements SupervisoryBody {
		private final String value;
		private final String supervisoryBodyScheme;
		
		protected SupervisoryBodyImpl(SupervisoryBody.SupervisoryBodyBuilder builder) {
			this.value = builder.getValue();
			this.supervisoryBodyScheme = builder.getSupervisoryBodyScheme();
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
		@RosettaAttribute("supervisoryBodyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBodyScheme")
		public String getSupervisoryBodyScheme() {
			return supervisoryBodyScheme;
		}
		
		@Override
		public SupervisoryBody build() {
			return this;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder toBuilder() {
			SupervisoryBody.SupervisoryBodyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupervisoryBody.SupervisoryBodyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSupervisoryBodyScheme()).ifPresent(builder::setSupervisoryBodyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisoryBody _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(supervisoryBodyScheme, _that.getSupervisoryBodyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (supervisoryBodyScheme != null ? supervisoryBodyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisoryBody {" +
				"value=" + this.value + ", " +
				"supervisoryBodyScheme=" + this.supervisoryBodyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SupervisoryBody  ***********************/
	class SupervisoryBodyBuilderImpl implements SupervisoryBody.SupervisoryBodyBuilder {
	
		protected String value;
		protected String supervisoryBodyScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("supervisoryBodyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBodyScheme")
		public String getSupervisoryBodyScheme() {
			return supervisoryBodyScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("supervisoryBodyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supervisoryBodyScheme")
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder setSupervisoryBodyScheme(String _supervisoryBodyScheme) {
			this.supervisoryBodyScheme = _supervisoryBodyScheme == null ? null : _supervisoryBodyScheme;
			return this;
		}
		
		@Override
		public SupervisoryBody build() {
			return new SupervisoryBody.SupervisoryBodyImpl(this);
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSupervisoryBodyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupervisoryBody.SupervisoryBodyBuilder o = (SupervisoryBody.SupervisoryBodyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSupervisoryBodyScheme(), o.getSupervisoryBodyScheme(), this::setSupervisoryBodyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisoryBody _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(supervisoryBodyScheme, _that.getSupervisoryBodyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (supervisoryBodyScheme != null ? supervisoryBodyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisoryBodyBuilder {" +
				"value=" + this.value + ", " +
				"supervisoryBodyScheme=" + this.supervisoryBodyScheme +
			'}';
		}
	}
}
