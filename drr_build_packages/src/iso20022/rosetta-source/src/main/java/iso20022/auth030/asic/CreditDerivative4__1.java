package iso20022.auth030.asic;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.asic.meta.CreditDerivative4__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditDerivative4__1", builder=CreditDerivative4__1.CreditDerivative4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CreditDerivative4__1", model="iso20022", builder=CreditDerivative4__1.CreditDerivative4__1BuilderImpl.class, version="${project.version}")
public interface CreditDerivative4__1 extends RosettaModelObject {

	CreditDerivative4__1Meta metaData = new CreditDerivative4__1Meta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getIndxFctr();
	TrancheIndicator3Choice__1 getTrch();

	/*********************** Build Methods  ***********************/
	CreditDerivative4__1 build();
	
	CreditDerivative4__1.CreditDerivative4__1Builder toBuilder();
	
	static CreditDerivative4__1.CreditDerivative4__1Builder builder() {
		return new CreditDerivative4__1.CreditDerivative4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDerivative4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDerivative4__1> getType() {
		return CreditDerivative4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indxFctr"), BigDecimal.class, getIndxFctr(), this);
		processRosetta(path.newSubPath("trch"), processor, TrancheIndicator3Choice__1.class, getTrch());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDerivative4__1Builder extends CreditDerivative4__1, RosettaModelObjectBuilder {
		TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder getOrCreateTrch();
		@Override
		TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder getTrch();
		CreditDerivative4__1.CreditDerivative4__1Builder setIndxFctr(BigDecimal indxFctr);
		CreditDerivative4__1.CreditDerivative4__1Builder setTrch(TrancheIndicator3Choice__1 trch);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("indxFctr"), BigDecimal.class, getIndxFctr(), this);
			processRosetta(path.newSubPath("trch"), processor, TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder.class, getTrch());
		}
		

		CreditDerivative4__1.CreditDerivative4__1Builder prune();
	}

	/*********************** Immutable Implementation of CreditDerivative4__1  ***********************/
	class CreditDerivative4__1Impl implements CreditDerivative4__1 {
		private final BigDecimal indxFctr;
		private final TrancheIndicator3Choice__1 trch;
		
		protected CreditDerivative4__1Impl(CreditDerivative4__1.CreditDerivative4__1Builder builder) {
			this.indxFctr = builder.getIndxFctr();
			this.trch = ofNullable(builder.getTrch()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indxFctr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indxFctr")
		public BigDecimal getIndxFctr() {
			return indxFctr;
		}
		
		@Override
		@RosettaAttribute("trch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trch")
		public TrancheIndicator3Choice__1 getTrch() {
			return trch;
		}
		
		@Override
		public CreditDerivative4__1 build() {
			return this;
		}
		
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder toBuilder() {
			CreditDerivative4__1.CreditDerivative4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDerivative4__1.CreditDerivative4__1Builder builder) {
			ofNullable(getIndxFctr()).ifPresent(builder::setIndxFctr);
			ofNullable(getTrch()).ifPresent(builder::setTrch);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDerivative4__1 _that = getType().cast(o);
		
			if (!Objects.equals(indxFctr, _that.getIndxFctr())) return false;
			if (!Objects.equals(trch, _that.getTrch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indxFctr != null ? indxFctr.hashCode() : 0);
			_result = 31 * _result + (trch != null ? trch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDerivative4__1 {" +
				"indxFctr=" + this.indxFctr + ", " +
				"trch=" + this.trch +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditDerivative4__1  ***********************/
	class CreditDerivative4__1BuilderImpl implements CreditDerivative4__1.CreditDerivative4__1Builder {
	
		protected BigDecimal indxFctr;
		protected TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder trch;
		
		@Override
		@RosettaAttribute("indxFctr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indxFctr")
		public BigDecimal getIndxFctr() {
			return indxFctr;
		}
		
		@Override
		@RosettaAttribute("trch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trch")
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder getTrch() {
			return trch;
		}
		
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder getOrCreateTrch() {
			TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder result;
			if (trch!=null) {
				result = trch;
			}
			else {
				result = trch = TrancheIndicator3Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("indxFctr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indxFctr")
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder setIndxFctr(BigDecimal _indxFctr) {
			this.indxFctr = _indxFctr == null ? null : _indxFctr;
			return this;
		}
		
		@RosettaAttribute("trch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trch")
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder setTrch(TrancheIndicator3Choice__1 _trch) {
			this.trch = _trch == null ? null : _trch.toBuilder();
			return this;
		}
		
		@Override
		public CreditDerivative4__1 build() {
			return new CreditDerivative4__1.CreditDerivative4__1Impl(this);
		}
		
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder prune() {
			if (trch!=null && !trch.prune().hasData()) trch = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndxFctr()!=null) return true;
			if (getTrch()!=null && getTrch().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditDerivative4__1.CreditDerivative4__1Builder o = (CreditDerivative4__1.CreditDerivative4__1Builder) other;
			
			merger.mergeRosetta(getTrch(), o.getTrch(), this::setTrch);
			
			merger.mergeBasic(getIndxFctr(), o.getIndxFctr(), this::setIndxFctr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDerivative4__1 _that = getType().cast(o);
		
			if (!Objects.equals(indxFctr, _that.getIndxFctr())) return false;
			if (!Objects.equals(trch, _that.getTrch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indxFctr != null ? indxFctr.hashCode() : 0);
			_result = 31 * _result + (trch != null ? trch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDerivative4__1Builder {" +
				"indxFctr=" + this.indxFctr + ", " +
				"trch=" + this.trch +
			'}';
		}
	}
}
