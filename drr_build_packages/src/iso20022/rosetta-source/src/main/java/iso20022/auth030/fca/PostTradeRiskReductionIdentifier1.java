package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.PostTradeRiskReductionIdentifier1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information about an post trade risk reduction identifier.
 * @version ${project.version}
 */
@RosettaDataType(value="PostTradeRiskReductionIdentifier1", builder=PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PostTradeRiskReductionIdentifier1", model="iso20022", builder=PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1BuilderImpl.class, version="${project.version}")
public interface PostTradeRiskReductionIdentifier1 extends RosettaModelObject {

	PostTradeRiskReductionIdentifier1Meta metaData = new PostTradeRiskReductionIdentifier1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of the structurer of the post trade risk reduction identifier.
	 */
	String getStrr();
	/**
	 * Post trade risk reduction identifier assigned by the structurer allowing to link the constituents.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	PostTradeRiskReductionIdentifier1 build();
	
	PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder toBuilder();
	
	static PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder builder() {
		return new PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostTradeRiskReductionIdentifier1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostTradeRiskReductionIdentifier1> getType() {
		return PostTradeRiskReductionIdentifier1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strr"), String.class, getStrr(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostTradeRiskReductionIdentifier1Builder extends PostTradeRiskReductionIdentifier1, RosettaModelObjectBuilder {
		PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder setStrr(String strr);
		PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strr"), String.class, getStrr(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder prune();
	}

	/*********************** Immutable Implementation of PostTradeRiskReductionIdentifier1  ***********************/
	class PostTradeRiskReductionIdentifier1Impl implements PostTradeRiskReductionIdentifier1 {
		private final String strr;
		private final String id;
		
		protected PostTradeRiskReductionIdentifier1Impl(PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder builder) {
			this.strr = builder.getStrr();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("strr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strr")
		public String getStrr() {
			return strr;
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
		public PostTradeRiskReductionIdentifier1 build() {
			return this;
		}
		
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder toBuilder() {
			PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder builder) {
			ofNullable(getStrr()).ifPresent(builder::setStrr);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeRiskReductionIdentifier1 _that = getType().cast(o);
		
			if (!Objects.equals(strr, _that.getStrr())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strr != null ? strr.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeRiskReductionIdentifier1 {" +
				"strr=" + this.strr + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PostTradeRiskReductionIdentifier1  ***********************/
	class PostTradeRiskReductionIdentifier1BuilderImpl implements PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder {
	
		protected String strr;
		protected String id;
		
		@Override
		@RosettaAttribute("strr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strr")
		public String getStrr() {
			return strr;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("strr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strr")
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder setStrr(String _strr) {
			this.strr = _strr == null ? null : _strr;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public PostTradeRiskReductionIdentifier1 build() {
			return new PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Impl(this);
		}
		
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrr()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder o = (PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder) other;
			
			
			merger.mergeBasic(getStrr(), o.getStrr(), this::setStrr);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeRiskReductionIdentifier1 _that = getType().cast(o);
		
			if (!Objects.equals(strr, _that.getStrr())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strr != null ? strr.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeRiskReductionIdentifier1Builder {" +
				"strr=" + this.strr + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
