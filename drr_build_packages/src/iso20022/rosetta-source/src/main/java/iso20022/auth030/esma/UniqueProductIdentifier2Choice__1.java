package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.UniqueProductIdentifier2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Element is a choice between a standard identifier and a proprietary code.
 * @version ${project.version}
 */
@RosettaDataType(value="UniqueProductIdentifier2Choice__1", builder=UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="UniqueProductIdentifier2Choice__1", model="iso20022", builder=UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
public interface UniqueProductIdentifier2Choice__1 extends RosettaModelObject {

	UniqueProductIdentifier2Choice__1Meta metaData = new UniqueProductIdentifier2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification through a unique product identifier.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	UniqueProductIdentifier2Choice__1 build();
	
	UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder toBuilder();
	
	static UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder builder() {
		return new UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UniqueProductIdentifier2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UniqueProductIdentifier2Choice__1> getType() {
		return UniqueProductIdentifier2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UniqueProductIdentifier2Choice__1Builder extends UniqueProductIdentifier2Choice__1, RosettaModelObjectBuilder {
		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of UniqueProductIdentifier2Choice__1  ***********************/
	class UniqueProductIdentifier2Choice__1Impl implements UniqueProductIdentifier2Choice__1 {
		private final String id;
		
		protected UniqueProductIdentifier2Choice__1Impl(UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder builder) {
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
		public UniqueProductIdentifier2Choice__1 build() {
			return this;
		}
		
		@Override
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder toBuilder() {
			UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueProductIdentifier2Choice__1 _that = getType().cast(o);
		
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
			return "UniqueProductIdentifier2Choice__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of UniqueProductIdentifier2Choice__1  ***********************/
	class UniqueProductIdentifier2Choice__1BuilderImpl implements UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder {
	
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
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public UniqueProductIdentifier2Choice__1 build() {
			return new UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Impl(this);
		}
		
		@Override
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder o = (UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueProductIdentifier2Choice__1 _that = getType().cast(o);
		
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
			return "UniqueProductIdentifier2Choice__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
