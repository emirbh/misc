package iso20022.auth108.hkma.dtcc;

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
import iso20022.auth108.hkma.dtcc.meta.GenericIdentification175__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to an identification, for example party identification or account identification.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification175__3", builder=GenericIdentification175__3.GenericIdentification175__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification175__3", model="iso20022", builder=GenericIdentification175__3.GenericIdentification175__3BuilderImpl.class, version="${project.version}")
public interface GenericIdentification175__3 extends RosettaModelObject {

	GenericIdentification175__3Meta metaData = new GenericIdentification175__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification assigned by an institution.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	GenericIdentification175__3 build();
	
	GenericIdentification175__3.GenericIdentification175__3Builder toBuilder();
	
	static GenericIdentification175__3.GenericIdentification175__3Builder builder() {
		return new GenericIdentification175__3.GenericIdentification175__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification175__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification175__3> getType() {
		return GenericIdentification175__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification175__3Builder extends GenericIdentification175__3, RosettaModelObjectBuilder {
		GenericIdentification175__3.GenericIdentification175__3Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		GenericIdentification175__3.GenericIdentification175__3Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification175__3  ***********************/
	class GenericIdentification175__3Impl implements GenericIdentification175__3 {
		private final String id;
		
		protected GenericIdentification175__3Impl(GenericIdentification175__3.GenericIdentification175__3Builder builder) {
			this.id = builder.getId();
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
		public GenericIdentification175__3 build() {
			return this;
		}
		
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder toBuilder() {
			GenericIdentification175__3.GenericIdentification175__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification175__3.GenericIdentification175__3Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__3 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__3 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification175__3  ***********************/
	class GenericIdentification175__3BuilderImpl implements GenericIdentification175__3.GenericIdentification175__3Builder {
	
		protected String id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public GenericIdentification175__3 build() {
			return new GenericIdentification175__3.GenericIdentification175__3Impl(this);
		}
		
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification175__3.GenericIdentification175__3Builder o = (GenericIdentification175__3.GenericIdentification175__3Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__3 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericIdentification175__3Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
