package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.GenericIdentification175__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification175__4", builder=GenericIdentification175__4.GenericIdentification175__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification175__4", model="iso20022", builder=GenericIdentification175__4.GenericIdentification175__4BuilderImpl.class, version="${project.version}")
public interface GenericIdentification175__4 extends RosettaModelObject {

	GenericIdentification175__4Meta metaData = new GenericIdentification175__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification assigned by an institution.
	 */
	String getId();
	/**
	 * Name of the identification scheme.
	 */
	String getSchmeNm();

	/*********************** Build Methods  ***********************/
	GenericIdentification175__4 build();
	
	GenericIdentification175__4.GenericIdentification175__4Builder toBuilder();
	
	static GenericIdentification175__4.GenericIdentification175__4Builder builder() {
		return new GenericIdentification175__4.GenericIdentification175__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification175__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification175__4> getType() {
		return GenericIdentification175__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification175__4Builder extends GenericIdentification175__4, RosettaModelObjectBuilder {
		GenericIdentification175__4.GenericIdentification175__4Builder setId(String id);
		GenericIdentification175__4.GenericIdentification175__4Builder setSchmeNm(String schmeNm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
		}
		

		GenericIdentification175__4.GenericIdentification175__4Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification175__4  ***********************/
	class GenericIdentification175__4Impl implements GenericIdentification175__4 {
		private final String id;
		private final String schmeNm;
		
		protected GenericIdentification175__4Impl(GenericIdentification175__4.GenericIdentification175__4Builder builder) {
			this.id = builder.getId();
			this.schmeNm = builder.getSchmeNm();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("schmeNm")
		public String getSchmeNm() {
			return schmeNm;
		}
		
		@Override
		public GenericIdentification175__4 build() {
			return this;
		}
		
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder toBuilder() {
			GenericIdentification175__4.GenericIdentification175__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification175__4.GenericIdentification175__4Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSchmeNm()).ifPresent(builder::setSchmeNm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__4 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__4 {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification175__4  ***********************/
	class GenericIdentification175__4BuilderImpl implements GenericIdentification175__4.GenericIdentification175__4Builder {
	
		protected String id;
		protected String schmeNm;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("schmeNm")
		public String getSchmeNm() {
			return schmeNm;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("schmeNm")
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder setSchmeNm(String _schmeNm) {
			this.schmeNm = _schmeNm == null ? null : _schmeNm;
			return this;
		}
		
		@Override
		public GenericIdentification175__4 build() {
			return new GenericIdentification175__4.GenericIdentification175__4Impl(this);
		}
		
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSchmeNm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__4.GenericIdentification175__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification175__4.GenericIdentification175__4Builder o = (GenericIdentification175__4.GenericIdentification175__4Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getSchmeNm(), o.getSchmeNm(), this::setSchmeNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__4 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__4Builder {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}
}
