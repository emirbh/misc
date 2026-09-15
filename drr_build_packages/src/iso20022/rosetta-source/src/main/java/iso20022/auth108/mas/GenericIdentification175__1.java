package iso20022.auth108.mas;

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
import iso20022.auth108.mas.meta.GenericIdentification175__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericIdentification175__1", builder=GenericIdentification175__1.GenericIdentification175__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericIdentification175__1", model="iso20022", builder=GenericIdentification175__1.GenericIdentification175__1BuilderImpl.class, version="${project.version}")
public interface GenericIdentification175__1 extends RosettaModelObject {

	GenericIdentification175__1Meta metaData = new GenericIdentification175__1Meta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	GenericIdentification175__1 build();
	
	GenericIdentification175__1.GenericIdentification175__1Builder toBuilder();
	
	static GenericIdentification175__1.GenericIdentification175__1Builder builder() {
		return new GenericIdentification175__1.GenericIdentification175__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericIdentification175__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericIdentification175__1> getType() {
		return GenericIdentification175__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericIdentification175__1Builder extends GenericIdentification175__1, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		GenericIdentification175__1.GenericIdentification175__1Builder prune();
	}

	/*********************** Immutable Implementation of GenericIdentification175__1  ***********************/
	class GenericIdentification175__1Impl implements GenericIdentification175__1 {
		private final String id;
		
		protected GenericIdentification175__1Impl(GenericIdentification175__1.GenericIdentification175__1Builder builder) {
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
		public GenericIdentification175__1 build() {
			return this;
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder toBuilder() {
			GenericIdentification175__1.GenericIdentification175__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericIdentification175__1.GenericIdentification175__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__1 _that = getType().cast(o);
		
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
			return "GenericIdentification175__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericIdentification175__1  ***********************/
	class GenericIdentification175__1BuilderImpl implements GenericIdentification175__1.GenericIdentification175__1Builder {
	
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
		public GenericIdentification175__1.GenericIdentification175__1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public GenericIdentification175__1 build() {
			return new GenericIdentification175__1.GenericIdentification175__1Impl(this);
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericIdentification175__1.GenericIdentification175__1Builder o = (GenericIdentification175__1.GenericIdentification175__1Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericIdentification175__1 _that = getType().cast(o);
		
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
			return "GenericIdentification175__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
