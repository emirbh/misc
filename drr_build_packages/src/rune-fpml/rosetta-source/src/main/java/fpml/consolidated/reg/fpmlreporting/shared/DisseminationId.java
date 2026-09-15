package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.DisseminationIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for dissemination identifiers.
 *
 */
@RosettaDataType(value="DisseminationId", builder=DisseminationId.DisseminationIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DisseminationId", model="fpml", builder=DisseminationId.DisseminationIdBuilderImpl.class, version="2.1.1")
public interface DisseminationId extends RosettaModelObject {

	DisseminationIdMeta metaData = new DisseminationIdMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getDisseminationIdScheme();

	/*********************** Build Methods  ***********************/
	DisseminationId build();
	
	DisseminationId.DisseminationIdBuilder toBuilder();
	
	static DisseminationId.DisseminationIdBuilder builder() {
		return new DisseminationId.DisseminationIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DisseminationId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DisseminationId> getType() {
		return DisseminationId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("disseminationIdScheme"), String.class, getDisseminationIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DisseminationIdBuilder extends DisseminationId, RosettaModelObjectBuilder {
		DisseminationId.DisseminationIdBuilder setValue(String value);
		DisseminationId.DisseminationIdBuilder setId(String id);
		DisseminationId.DisseminationIdBuilder setDisseminationIdScheme(String disseminationIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("disseminationIdScheme"), String.class, getDisseminationIdScheme(), this);
		}
		

		DisseminationId.DisseminationIdBuilder prune();
	}

	/*********************** Immutable Implementation of DisseminationId  ***********************/
	class DisseminationIdImpl implements DisseminationId {
		private final String value;
		private final String id;
		private final String disseminationIdScheme;
		
		protected DisseminationIdImpl(DisseminationId.DisseminationIdBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
			this.disseminationIdScheme = builder.getDisseminationIdScheme();
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
		@RosettaAttribute("disseminationIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationIdScheme")
		public String getDisseminationIdScheme() {
			return disseminationIdScheme;
		}
		
		@Override
		public DisseminationId build() {
			return this;
		}
		
		@Override
		public DisseminationId.DisseminationIdBuilder toBuilder() {
			DisseminationId.DisseminationIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DisseminationId.DisseminationIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDisseminationIdScheme()).ifPresent(builder::setDisseminationIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisseminationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(disseminationIdScheme, _that.getDisseminationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (disseminationIdScheme != null ? disseminationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisseminationId {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"disseminationIdScheme=" + this.disseminationIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DisseminationId  ***********************/
	class DisseminationIdBuilderImpl implements DisseminationId.DisseminationIdBuilder {
	
		protected String value;
		protected String id;
		protected String disseminationIdScheme;
		
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
		@RosettaAttribute("disseminationIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationIdScheme")
		public String getDisseminationIdScheme() {
			return disseminationIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DisseminationId.DisseminationIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DisseminationId.DisseminationIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("disseminationIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disseminationIdScheme")
		@Override
		public DisseminationId.DisseminationIdBuilder setDisseminationIdScheme(String _disseminationIdScheme) {
			this.disseminationIdScheme = _disseminationIdScheme == null ? null : _disseminationIdScheme;
			return this;
		}
		
		@Override
		public DisseminationId build() {
			return new DisseminationId.DisseminationIdImpl(this);
		}
		
		@Override
		public DisseminationId.DisseminationIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisseminationId.DisseminationIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			if (getDisseminationIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisseminationId.DisseminationIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DisseminationId.DisseminationIdBuilder o = (DisseminationId.DisseminationIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDisseminationIdScheme(), o.getDisseminationIdScheme(), this::setDisseminationIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisseminationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(disseminationIdScheme, _that.getDisseminationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (disseminationIdScheme != null ? disseminationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisseminationIdBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"disseminationIdScheme=" + this.disseminationIdScheme +
			'}';
		}
	}
}
