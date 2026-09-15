package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.PortfolioIdentification3__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioIdentification3__1", builder=PortfolioIdentification3__1.PortfolioIdentification3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PortfolioIdentification3__1", model="iso20022", builder=PortfolioIdentification3__1.PortfolioIdentification3__1BuilderImpl.class, version="${project.version}")
public interface PortfolioIdentification3__1 extends RosettaModelObject {

	PortfolioIdentification3__1Meta metaData = new PortfolioIdentification3__1Meta();

	/*********************** Getter Methods  ***********************/
	String getCd();

	/*********************** Build Methods  ***********************/
	PortfolioIdentification3__1 build();
	
	PortfolioIdentification3__1.PortfolioIdentification3__1Builder toBuilder();
	
	static PortfolioIdentification3__1.PortfolioIdentification3__1Builder builder() {
		return new PortfolioIdentification3__1.PortfolioIdentification3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioIdentification3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioIdentification3__1> getType() {
		return PortfolioIdentification3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioIdentification3__1Builder extends PortfolioIdentification3__1, RosettaModelObjectBuilder {
		PortfolioIdentification3__1.PortfolioIdentification3__1Builder setCd(String cd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
		}
		

		PortfolioIdentification3__1.PortfolioIdentification3__1Builder prune();
	}

	/*********************** Immutable Implementation of PortfolioIdentification3__1  ***********************/
	class PortfolioIdentification3__1Impl implements PortfolioIdentification3__1 {
		private final String cd;
		
		protected PortfolioIdentification3__1Impl(PortfolioIdentification3__1.PortfolioIdentification3__1Builder builder) {
			this.cd = builder.getCd();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		public PortfolioIdentification3__1 build() {
			return this;
		}
		
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder toBuilder() {
			PortfolioIdentification3__1.PortfolioIdentification3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioIdentification3__1.PortfolioIdentification3__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioIdentification3__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioIdentification3__1 {" +
				"cd=" + this.cd +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioIdentification3__1  ***********************/
	class PortfolioIdentification3__1BuilderImpl implements PortfolioIdentification3__1.PortfolioIdentification3__1Builder {
	
		protected String cd;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder setCd(String _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@Override
		public PortfolioIdentification3__1 build() {
			return new PortfolioIdentification3__1.PortfolioIdentification3__1Impl(this);
		}
		
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioIdentification3__1.PortfolioIdentification3__1Builder o = (PortfolioIdentification3__1.PortfolioIdentification3__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioIdentification3__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioIdentification3__1Builder {" +
				"cd=" + this.cd +
			'}';
		}
	}
}
