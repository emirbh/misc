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
import iso20022.auth108.iso.meta.SupplementaryDataEnvelope1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Technical component that contains the validated supplementary data information. This technical envelope allows to segregate the supplementary data information from any other information.
 * @version ${project.version}
 */
@RosettaDataType(value="SupplementaryDataEnvelope1", builder=SupplementaryDataEnvelope1.SupplementaryDataEnvelope1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SupplementaryDataEnvelope1", model="iso20022", builder=SupplementaryDataEnvelope1.SupplementaryDataEnvelope1BuilderImpl.class, version="${project.version}")
public interface SupplementaryDataEnvelope1 extends RosettaModelObject {

	SupplementaryDataEnvelope1Meta metaData = new SupplementaryDataEnvelope1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: lax.
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	SupplementaryDataEnvelope1 build();
	
	SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder toBuilder();
	
	static SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder builder() {
		return new SupplementaryDataEnvelope1.SupplementaryDataEnvelope1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupplementaryDataEnvelope1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SupplementaryDataEnvelope1> getType() {
		return SupplementaryDataEnvelope1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupplementaryDataEnvelope1Builder extends SupplementaryDataEnvelope1, RosettaModelObjectBuilder {
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder prune();
	}

	/*********************** Immutable Implementation of SupplementaryDataEnvelope1  ***********************/
	class SupplementaryDataEnvelope1Impl implements SupplementaryDataEnvelope1 {
		private final String anyContents;
		
		protected SupplementaryDataEnvelope1Impl(SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder builder) {
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public SupplementaryDataEnvelope1 build() {
			return this;
		}
		
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder toBuilder() {
			SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryDataEnvelope1 _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryDataEnvelope1 {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of SupplementaryDataEnvelope1  ***********************/
	class SupplementaryDataEnvelope1BuilderImpl implements SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder {
	
		protected String anyContents;
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("anyContents")
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public SupplementaryDataEnvelope1 build() {
			return new SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Impl(this);
		}
		
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder o = (SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupplementaryDataEnvelope1 _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupplementaryDataEnvelope1Builder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
