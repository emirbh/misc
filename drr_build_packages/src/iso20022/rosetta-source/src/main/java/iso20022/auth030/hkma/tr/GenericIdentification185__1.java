package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.GenericIdentification185__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification185__1", builder=GenericIdentification185__1.GenericIdentification185__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification185__1", model="iso20022", builder=GenericIdentification185__1.GenericIdentification185__1BuilderImpl.class, version="${project.version}")
public interface GenericIdentification185__1 extends RosettaModelObject {

	GenericIdentification185__1Meta metaData = new GenericIdentification185__1Meta();

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
	GenericIdentification185__1 build();
	
	GenericIdentification185__1.GenericIdentification185__1Builder toBuilder();
	
	static GenericIdentification185__1.GenericIdentification185__1Builder builder() {
		return new GenericIdentification185__1.GenericIdentification185__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification185__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification185__1> getType() {
		return GenericIdentification185__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification185__1Builder extends GenericIdentification185__1, RosettaModelObjectBuilder {
		GenericIdentification185__1.GenericIdentification185__1Builder setId(String id);
		GenericIdentification185__1.GenericIdentification185__1Builder setSchmeNm(String schmeNm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
		}
		

		GenericIdentification185__1.GenericIdentification185__1Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification185__1  ***********************/
	class GenericIdentification185__1Impl implements GenericIdentification185__1 {
		private final String id;
		private final String schmeNm;
		
		protected GenericIdentification185__1Impl(GenericIdentification185__1.GenericIdentification185__1Builder builder) {
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
		public GenericIdentification185__1 build() {
			return this;
		}
		
		@Override
		public GenericIdentification185__1.GenericIdentification185__1Builder toBuilder() {
			GenericIdentification185__1.GenericIdentification185__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification185__1.GenericIdentification185__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSchmeNm()).ifPresent(builder::setSchmeNm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification185__1 _that = getType().cast(o);
		
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
			return "GenericIdentification185__1 {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification185__1  ***********************/
	class GenericIdentification185__1BuilderImpl implements GenericIdentification185__1.GenericIdentification185__1Builder {
	
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
		public GenericIdentification185__1.GenericIdentification185__1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("schmeNm")
		@Override
		public GenericIdentification185__1.GenericIdentification185__1Builder setSchmeNm(String _schmeNm) {
			this.schmeNm = _schmeNm == null ? null : _schmeNm;
			return this;
		}
		
		@Override
		public GenericIdentification185__1 build() {
			return new GenericIdentification185__1.GenericIdentification185__1Impl(this);
		}
		
		@Override
		public GenericIdentification185__1.GenericIdentification185__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification185__1.GenericIdentification185__1Builder prune() {
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
		public GenericIdentification185__1.GenericIdentification185__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification185__1.GenericIdentification185__1Builder o = (GenericIdentification185__1.GenericIdentification185__1Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getSchmeNm(), o.getSchmeNm(), this::setSchmeNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification185__1 _that = getType().cast(o);
		
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
			return "GenericIdentification185__1Builder {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}
}
