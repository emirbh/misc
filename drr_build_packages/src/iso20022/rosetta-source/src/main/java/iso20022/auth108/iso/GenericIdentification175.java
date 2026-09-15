package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.GenericIdentification175Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification175", builder=GenericIdentification175.GenericIdentification175BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification175", model="iso20022", builder=GenericIdentification175.GenericIdentification175BuilderImpl.class, version="${project.version}")
public interface GenericIdentification175 extends RosettaModelObject {

	GenericIdentification175Meta metaData = new GenericIdentification175Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification assigned by an institution.
	 */
	String getId();
	/**
	 * Name of the identification scheme.
	 */
	String getSchmeNm();
	/**
	 * Entity that assigns the identification.
	 */
	String getIssr();

	/*********************** Build Methods  ***********************/
	GenericIdentification175 build();
	
	GenericIdentification175.GenericIdentification175Builder toBuilder();
	
	static GenericIdentification175.GenericIdentification175Builder builder() {
		return new GenericIdentification175.GenericIdentification175BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification175> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification175> getType() {
		return GenericIdentification175.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
		processor.processBasic(path.newSubPath("issr"), String.class, getIssr(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification175Builder extends GenericIdentification175, RosettaModelObjectBuilder {
		GenericIdentification175.GenericIdentification175Builder setId(String id);
		GenericIdentification175.GenericIdentification175Builder setSchmeNm(String schmeNm);
		GenericIdentification175.GenericIdentification175Builder setIssr(String issr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("schmeNm"), String.class, getSchmeNm(), this);
			processor.processBasic(path.newSubPath("issr"), String.class, getIssr(), this);
		}
		

		GenericIdentification175.GenericIdentification175Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification175  ***********************/
	class GenericIdentification175Impl implements GenericIdentification175 {
		private final String id;
		private final String schmeNm;
		private final String issr;
		
		protected GenericIdentification175Impl(GenericIdentification175.GenericIdentification175Builder builder) {
			this.id = builder.getId();
			this.schmeNm = builder.getSchmeNm();
			this.issr = builder.getIssr();
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
		@RosettaAttribute("issr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issr")
		public String getIssr() {
			return issr;
		}
		
		@Override
		public GenericIdentification175 build() {
			return this;
		}
		
		@Override
		public GenericIdentification175.GenericIdentification175Builder toBuilder() {
			GenericIdentification175.GenericIdentification175Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification175.GenericIdentification175Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSchmeNm()).ifPresent(builder::setSchmeNm);
			ofNullable(getIssr()).ifPresent(builder::setIssr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			if (!Objects.equals(issr, _that.getIssr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			_result = 31 * _result + (issr != null ? issr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175 {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm + ", " +
				"issr=" + this.issr +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification175  ***********************/
	class GenericIdentification175BuilderImpl implements GenericIdentification175.GenericIdentification175Builder {
	
		protected String id;
		protected String schmeNm;
		protected String issr;
		
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
		@RosettaAttribute("issr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issr")
		public String getIssr() {
			return issr;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public GenericIdentification175.GenericIdentification175Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("schmeNm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("schmeNm")
		@Override
		public GenericIdentification175.GenericIdentification175Builder setSchmeNm(String _schmeNm) {
			this.schmeNm = _schmeNm == null ? null : _schmeNm;
			return this;
		}
		
		@RosettaAttribute("issr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issr")
		@Override
		public GenericIdentification175.GenericIdentification175Builder setIssr(String _issr) {
			this.issr = _issr == null ? null : _issr;
			return this;
		}
		
		@Override
		public GenericIdentification175 build() {
			return new GenericIdentification175.GenericIdentification175Impl(this);
		}
		
		@Override
		public GenericIdentification175.GenericIdentification175Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175.GenericIdentification175Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSchmeNm()!=null) return true;
			if (getIssr()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175.GenericIdentification175Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification175.GenericIdentification175Builder o = (GenericIdentification175.GenericIdentification175Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getSchmeNm(), o.getSchmeNm(), this::setSchmeNm);
			merger.mergeBasic(getIssr(), o.getIssr(), this::setIssr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			if (!Objects.equals(issr, _that.getIssr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			_result = 31 * _result + (issr != null ? issr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175Builder {" +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm + ", " +
				"issr=" + this.issr +
			'}';
		}
	}
}
