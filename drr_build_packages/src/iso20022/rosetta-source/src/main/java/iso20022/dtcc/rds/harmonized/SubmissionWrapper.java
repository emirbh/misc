package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.SubmissionWrapperMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SubmissionWrapper", builder=SubmissionWrapper.SubmissionWrapperBuilderImpl.class, version="${project.version}")
@RuneDataType(value="SubmissionWrapper", model="iso20022", builder=SubmissionWrapper.SubmissionWrapperBuilderImpl.class, version="${project.version}")
public interface SubmissionWrapper extends RosettaModelObject {

	SubmissionWrapperMeta metaData = new SubmissionWrapperMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: skip.
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	SubmissionWrapper build();
	
	SubmissionWrapper.SubmissionWrapperBuilder toBuilder();
	
	static SubmissionWrapper.SubmissionWrapperBuilder builder() {
		return new SubmissionWrapper.SubmissionWrapperBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SubmissionWrapper> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SubmissionWrapper> getType() {
		return SubmissionWrapper.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubmissionWrapperBuilder extends SubmissionWrapper, RosettaModelObjectBuilder {
		SubmissionWrapper.SubmissionWrapperBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		SubmissionWrapper.SubmissionWrapperBuilder prune();
	}

	/*********************** Immutable Implementation of SubmissionWrapper  ***********************/
	class SubmissionWrapperImpl implements SubmissionWrapper {
		private final String anyContents;
		
		protected SubmissionWrapperImpl(SubmissionWrapper.SubmissionWrapperBuilder builder) {
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
		public SubmissionWrapper build() {
			return this;
		}
		
		@Override
		public SubmissionWrapper.SubmissionWrapperBuilder toBuilder() {
			SubmissionWrapper.SubmissionWrapperBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubmissionWrapper.SubmissionWrapperBuilder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubmissionWrapper _that = getType().cast(o);
		
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
			return "SubmissionWrapper {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of SubmissionWrapper  ***********************/
	class SubmissionWrapperBuilderImpl implements SubmissionWrapper.SubmissionWrapperBuilder {
	
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
		public SubmissionWrapper.SubmissionWrapperBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public SubmissionWrapper build() {
			return new SubmissionWrapper.SubmissionWrapperImpl(this);
		}
		
		@Override
		public SubmissionWrapper.SubmissionWrapperBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubmissionWrapper.SubmissionWrapperBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubmissionWrapper.SubmissionWrapperBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubmissionWrapper.SubmissionWrapperBuilder o = (SubmissionWrapper.SubmissionWrapperBuilder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubmissionWrapper _that = getType().cast(o);
		
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
			return "SubmissionWrapperBuilder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
