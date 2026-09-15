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
import iso20022.auth030.hkma.dtcc.meta.GenericIdentification184Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example, party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification184", builder=GenericIdentification184.GenericIdentification184BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification184", model="iso20022", builder=GenericIdentification184.GenericIdentification184BuilderImpl.class, version="${project.version}")
public interface GenericIdentification184 extends RosettaModelObject {

	GenericIdentification184Meta metaData = new GenericIdentification184Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates other identifier of an underlier.
	 */
	String getId();
	/**
	 * Indicates the source of the identifier that represent the underlier.
	 */
	String getSrc();

	/*********************** Build Methods  ***********************/
	GenericIdentification184 build();
	
	GenericIdentification184.GenericIdentification184Builder toBuilder();
	
	static GenericIdentification184.GenericIdentification184Builder builder() {
		return new GenericIdentification184.GenericIdentification184BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification184> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification184> getType() {
		return GenericIdentification184.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("src"), String.class, getSrc(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification184Builder extends GenericIdentification184, RosettaModelObjectBuilder {
		GenericIdentification184.GenericIdentification184Builder setId(String id);
		GenericIdentification184.GenericIdentification184Builder setSrc(String src);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("src"), String.class, getSrc(), this);
		}
		

		GenericIdentification184.GenericIdentification184Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification184  ***********************/
	class GenericIdentification184Impl implements GenericIdentification184 {
		private final String id;
		private final String src;
		
		protected GenericIdentification184Impl(GenericIdentification184.GenericIdentification184Builder builder) {
			this.id = builder.getId();
			this.src = builder.getSrc();
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
		@RosettaAttribute("src")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("src")
		public String getSrc() {
			return src;
		}
		
		@Override
		public GenericIdentification184 build() {
			return this;
		}
		
		@Override
		public GenericIdentification184.GenericIdentification184Builder toBuilder() {
			GenericIdentification184.GenericIdentification184Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification184.GenericIdentification184Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSrc()).ifPresent(builder::setSrc);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification184 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(src, _that.getSrc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (src != null ? src.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification184 {" +
				"id=" + this.id + ", " +
				"src=" + this.src +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification184  ***********************/
	class GenericIdentification184BuilderImpl implements GenericIdentification184.GenericIdentification184Builder {
	
		protected String id;
		protected String src;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("src")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("src")
		public String getSrc() {
			return src;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public GenericIdentification184.GenericIdentification184Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("src")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("src")
		@Override
		public GenericIdentification184.GenericIdentification184Builder setSrc(String _src) {
			this.src = _src == null ? null : _src;
			return this;
		}
		
		@Override
		public GenericIdentification184 build() {
			return new GenericIdentification184.GenericIdentification184Impl(this);
		}
		
		@Override
		public GenericIdentification184.GenericIdentification184Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification184.GenericIdentification184Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSrc()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification184.GenericIdentification184Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification184.GenericIdentification184Builder o = (GenericIdentification184.GenericIdentification184Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getSrc(), o.getSrc(), this::setSrc);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification184 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(src, _that.getSrc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (src != null ? src.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification184Builder {" +
				"id=" + this.id + ", " +
				"src=" + this.src +
			'}';
		}
	}
}
